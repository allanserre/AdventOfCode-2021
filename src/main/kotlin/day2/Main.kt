
import java.io.File
import java.util.*
import kotlin.streams.toList


fun main(args: Array<String>) {

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/input.txt")
/*
    var depth = 0;
    var forward = 0;

    file.forEachLine {
        var tab =  it.split(" ")
        var mouvement = tab.first()
        var num = tab.last().toInt()
        when ( mouvement ){
            "forward" -> { forward += num }
            "down" ->    { depth += num   }
            "up" ->      { depth -= num   }
            else -> {}
        }

    }
    println("profondeur : $depth \navancement : $forward")
    println("resultat : " + (depth * forward))*/



    var depth = 0;
    var aim =   0;
    var forward = 0;

    file.forEachLine {
        var tab =  it.split(" ")
        var mouvement = tab.first()
        var num = tab.last().toInt()

        when ( mouvement ){
            "forward" -> {
                forward += num
                depth   += ( num * aim )
            }
            "down" ->    { aim += num   }
            "up" ->      { aim -= num   }
            else -> {}
        }
    }

    println("profondeur : $depth \navancement : $forward")
    println("resultat : " + (depth * forward))
}