package day9

import com.sun.jdi.IntegerValue
import java.io.File
import java.util.*
import javax.xml.stream.events.Characters
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.streams.toList


fun main(args: Array<String>) {

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day9/input.txt")

    val lst = file.bufferedReader().lines().toList()
    val x = lst[0].length
    val y = lst.size

    var grid = List(y) { MutableList(x){0} }

    lst.forEachIndexed { index, line ->
        line.forEachIndexed { index2 , char ->
            grid[index][index2] = Character.getNumericValue(char)
        }
    }

    var risk_level = 0
    for ( i in grid.indices){
        for ( j in grid[0].indices){
            var nb_inf = 0
            val num = grid[i][j]

            if ( i == 0 || i == grid.size-1) nb_inf ++;
            if ( j == 0 || j == grid[0].size -1) nb_inf ++;

            if ( i > 0 && grid[i-1][j] > num) nb_inf ++
            if ( i < grid.size-1 && grid[i+1][j] > num) nb_inf ++
            if ( j < grid[0].size-1 && grid[i][j+1] > num ) nb_inf ++
            if ( j > 0 && grid[i][j-1] > num ) nb_inf ++

            if ( nb_inf == 4) risk_level += ( grid[i][j] + 1 )
        }
    }
    println(risk_level)
}