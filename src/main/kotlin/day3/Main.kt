
import java.io.File
import java.util.*
import kotlin.streams.toList


fun main(args: Array<String>) {
/*
    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day3/test-input.txt")
    var tab : Array<Int> = Array(file.bufferedReader().readLine().length){0};

    file.forEachLine {
        it.forEachIndexed { index , it ->
            tab[index] += if ( Character.getNumericValue(it) == 0) -1 else 1
        }
    }

    var gammaString : String = tab.map { x -> if ( x>=0 ) "1" else "0" }.reduce{ x,y -> x + y }
    var gamma : Int = Integer.valueOf(gammaString,2)

    var epsilonString : String = tab.map { x -> if ( x>=0 ) "0" else "1" }.reduce{ x,y -> x + y }
    var epsilon : Int = Integer.valueOf(epsilonString,2)
    println("gamma : $gamma \b epsilon : $epsilon")

    var result = epsilon * gamma
    println(result)*/

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day3/input.txt")
    val size = file.bufferedReader().readLine().length

    var lines = file.bufferedReader().lines().toList()

    var i = 0;
    do{
        var num = 0;
        lines.forEachIndexed{ index , it ->
            num += if (Character.getNumericValue(it[i]) == 0) -1 else 1
        }
        lines = lines.filter { x -> Character.getNumericValue(x[i]) == ( if ( num >= 0 ) 1 else 0) }
        i ++
    }while (lines.size != 1)

    var oxygen : Int = Integer.valueOf(lines[0],2)
    lines = file.bufferedReader().lines().toList()
    i = 0;

    do{
        var num = 0;
        lines.forEachIndexed{ index , it ->
            num += if (Character.getNumericValue(it[i]) == 0) -1 else 1
        }
        lines = lines.filter { x -> Character.getNumericValue(x[i]) == ( if ( num >= 0 ) 0 else 1) }
        i++
    }while (lines.size != 1)

    var scrubber : Int = Integer.valueOf(lines[0],2)

    println("oxygen : $oxygen \n" +
            "epsilon : $scrubber")

    var result = oxygen * scrubber
    println(result)


}