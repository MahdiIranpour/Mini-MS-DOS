
import java.io.File

fun main(){

    var comm : String
    var parts: Array<String>
    while (true) {

        comm = readln()

        parts = comm.split(" ").toTypedArray()

        when (parts[0]) {

            "CF" -> {     //Create file
                create_file(parts[1])
            }

            "CFN" ->{}  //Change file name

            "RMF" ->{} //Remove file
        }

    }
}

fun create_file( name : String) {

    val res = create_and_get_path(name)

    if (res.isNotEmpty()){
        println("file $name is created in $res")
    } else{
        println("failed to create file $name")
    }

    return
}

fun create_and_get_path(name: String): String {
    val file = File(name)
    return file.canonicalPath
}

