package day9

import java.io.File
import kotlin.streams.toList


fun main(args: Array<String>) {

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day9/test-input.txt")

    val lst = file.bufferedReader().lines().toList()
    val x = lst[0].length
    val y = lst.size

    var grid = List(y) { MutableList(x){0} }

    lst.forEachIndexed { index, line ->
        line.forEachIndexed { index2 , char ->
            grid[index][index2] = Character.getNumericValue(char)
        }
    }

    var char_grid = List(y) { i ->
        grid[i].map { x -> if (x == 9) "*" else "." }.toMutableList()
    }

    nb_voisins(char_grid,0 ,0)

    println(char_grid)
}

fun nb_voisins(grid : List<MutableList<String>>, ind1 : Int , ind2: Int ) : Int {

    for ( i in grid.indices){
        for ( j in grid[0].indices){
            val num = grid[i][j]

            if ( i > 0 && grid[i-1][j] == "."){
                grid[i-1][j] = " "
            }
            if ( i < grid.size-1 && grid[i+1][j] == "."){

            }
            if ( j < grid[0].size-1 && grid[i][j+1] == "." ){
                
            }
            if ( j > 0 && grid[i][j-1] == "." )
        }
    }


}

