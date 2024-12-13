import java.io.File
import kotlin.system.exitProcess

fun main() {

    var comm: String
    var parts: Array<String>

    while (true) {

        comm = readln()

        parts = comm.split(" ").toTypedArray()

        when (parts[0].uppercase()) {

            "CF" -> {   //Create file
                createFile(parts[1])
            }

            "CFN" -> {   //Change file name
                changeFileName(parts[1], parts[2])
            }

            "RMF" -> {   //Remove file
                removeFile(parts[1])
            }

            "EXIT" -> {
                exit()
            }

            "HELP" -> {
                println("CF - Create a new file => CF 'path_to_the_file'")
                println("CFN - Change file name or format => CFN 'path_to_the_file' 'target_name/format'")
                println("RMF - Remove file => RMF 'path_to_the_file'")

                println("EXIT - Exit the terminal")
            }

            else -> {
                println("${parts[0]} is not recognized as an internal or external command")
            }
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

fun changeFileName(current_name: String, target_name: String) {

    val file = File(current_name)

    if (file.exists().not()) {
        println("file $file does not exists")
        return
    }

    if (file.renameTo(File(target_name)))
        println("file $current_name renamed to $target_name")
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

