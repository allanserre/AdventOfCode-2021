package day1

import java.io.File


fun main(args: Array<String>) {
    /*
    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day1/input.txt")

    var increase_nb = -1
    var previous    = 0

    file.forEachLine {
        var num = it.toInt()
        if ( num > previous){
            increase_nb ++
        }
        previous = num
    }

    println(increase_nb)*/

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day1/input.txt")

    var tab : ArrayList<Int> = ArrayList<Int>();
    var increase_nb = -1
    var previous    = 0

    file.forEachLine {
        tab.add(it.toInt())
    }

    for ( i in 0..(tab.size-3) ){
        var num = tab[i] + tab[i + 1] + tab[i + 2]
        if ( num > previous){
            increase_nb ++
        }
        previous = num
    }

    println(increase_nb)
}
