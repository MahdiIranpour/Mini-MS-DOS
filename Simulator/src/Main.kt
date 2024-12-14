import java.io.File
import java.nio.file.Files
import kotlin.system.exitProcess
import java.nio.file.attribute.BasicFileAttributes
import java.time.format.DateTimeFormatter

var currentDirectory = File("C:\\Users\\Laptopkaran")

fun main() {

    

    var comm: String
    var parts: Array<String>

    while (true) {

        print("$currentDirectory>")
        comm = readln()

        parts = comm.split(" ").toTypedArray()

        when (parts[0].uppercase()) {

            "ECHO." -> {   //Create file
                createFile(parts[1])
            }

            "COPY" -> {     //copy file to path
                copyFile(parts[1], parts[2])
            }

            "MOVE" -> {     //move file to path
                cutFile(parts[1], parts[2])
            }

            "REN" -> {   //Change file name
                changeFileName(parts[1], parts[2])
            }

            "DEL" -> {   //Remove file
                removeFile(parts[1])
            }

            "CD" -> {   //work with current directory
                if (parts.size > 1)
                    changeDirectory(parts[1])
                else
                    changeDirectory("")
            }

            "DIR" -> {  //show files in current directory
                showCurrentDirectory()
            }

            "EXIT" -> {
                exit()
            }

            "HELP" -> {
                printCommandList()
            }

            else -> {
                if (comm[1] == ':')
                    setDrive(comm)
                else
                    println("${parts[0]} is not recognized as an internal or external command")
            }
        }

        println()
    }
}

fun printCommandList() {

    println("echo. - Create a new file => echo. 'path to the file'")
    println("ren - Change file name or format => ren 'path to the file' 'target name/format'")
    println("del - Remove file => del 'path_to_the_file'")
    println("cd : for showing current directory => cd")
    println("for change current directory to a determined folder => cd 'folder name'")
    println("for change current directory to parent directory => cd ..")
    println("for change current directory to absolute path => cd 'absolute path to the folder'")
    println("back to root directory on current drive => cd \\")
    println("'Drive name' to change current drive => E:")
    println("dir - get List of files in current directory")
    println("move - move a file to a new location => move 'file name' 'path'")
    println("copy - copy a file to a location => copy 'file name' 'path'")
    println("EXIT - Exit the terminal")
}

fun cutFile(fileName: String, path: String) {

    val file = File(fileName)

    if (!file.exists()){
        println("$file does not exist")
        return
    }

    file.copyTo(File("$path\\$fileName"))
    file.delete()
    println("$file moved to $path")
}

fun copyFile(fileName: String, path: String) {

    val file = File(fileName)

    if (!file.exists()){
        println("$file does not exist")
        return
    }

    file.copyTo(File("$path\\$fileName"))
    println("$file copied to $path")
}

fun setDrive(driveName: String) {

    val drives = File.listRoots()

    val selectedDrive = drives.find { it.absolutePath.startsWith(driveName) }

    if (selectedDrive != null) {
        currentDirectory = selectedDrive
    } else{
        println("Drive not found!")
    }
}
fun showCurrentDirectory() {

    val files = currentDirectory.listFiles()

    for (file in files!!) {
        printFile(file)
    }
}

fun printFile(file: File) {

    val path = file.toPath()

    val attributes = path.let {
        Files.readAttributes(it, BasicFileAttributes::class.java)
    }

    val creationTime = attributes?.creationTime()?.toInstant()
    val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss")
    val formattedTime = formatter.format(creationTime?.atZone(java.time.ZoneId.systemDefault()))

    val directoryOrFile = if (file.isDirectory) "<DIR>" else "    "

    val size = attributes.size()

    if (size.toString().length <= 4)
        println("$formattedTime     $directoryOrFile    $size \t\t${file.name}")
    else
        println("$formattedTime     $directoryOrFile    $size \t${file.name}")
}

fun changeDirectory(targetDir: String) {

    if (targetDir == "..") {
        currentDirectory = currentDirectory.parentFile
        return
    } else if (targetDir == "\\") {

        val drive = currentDirectory.absolutePath.substring(0, 2) // for example D:
        currentDirectory = File("$drive/")

    } else if (targetDir.isBlank()) {
        println("$currentDirectory")

    } else if (!targetDir.contains(":")) {

        val file = File("$currentDirectory\\$targetDir")

        if (file.exists() and file.isDirectory) {

            currentDirectory = file
        } else {
            println("$file does not or it is not a directory")
        }

    } else {

        val file = File(targetDir)

        if (file.exists() and file.isDirectory) {

            currentDirectory = file

        } else {
            println("$file does not or it is not a directory")
        }
    }
}


fun exit() {
    println("Bye!")
    exitProcess(0)
}

fun removeFile(fileName: String) {

    val file = File(fileName)

    if (file.exists()) {
        if (file.delete())
            println("file $file removed successfully")
        else
            println("failed to delete $file")
    } else
        println("file $file does not exist")
}

fun changeFileName(currentName: String, targetName: String) {

    val file = File(currentName)

    if (file.exists().not()) {
        println("file $file does not exists")
        return
    }

    if (file.renameTo(File(targetName)))
        println("file $currentName renamed to $targetName")
}

fun createFile(name: String) {

    val res = createAndGetPath(name)

    if (res.isNotEmpty()) {
        println("file $name is created in $res")
    } else {
        println("failed to create file $name")
    }

    return
}

fun createAndGetPath(name: String): String {
    val file = File(name)
    file.createNewFile()
    return file.canonicalPath
}

