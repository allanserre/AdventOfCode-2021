package day5

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.streams.toList


fun main(args: Array<String>) {

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day5/input.txt")
    val coords  = file.bufferedReader().lines().toList()
        .map { x -> x.replace(" -> ",",") }
        .map { x -> Coord(
            x.split(",")[0].toInt(),
            x.split(",")[1].toInt(),
            x.split(",")[2].toInt(),
            x.split(",")[3].toInt()
        )}
    var tab = List(1000) { MutableList(1000){0} }

    coords.forEach {
        if ( it.x1 == it.x2 ){
            for ( i in it.minY()..it.maxY()) {
                tab[i][it.x1] ++
            }
        }
        if ( it.y1 == it.y2 ){
            for ( i in it.minX()..it.maxX()) {
                tab[it.y1][i] ++
            }
        }
        if ( it.x1 != it.x2 && it.y1 != it.y2 ){
            if ( it.x1 < it.x2 && it.y1 < it.y2 || it.x1 > it.x2 && it.y1 > it.y2){
                for ( i in it.minX()..it.maxX()) {
                    for ( p in it.minY()..it.maxY()) {
                        if ( i-p == it.minX() - it.minY()){

                            tab[p][i] ++
                        }
                    }
                }
            }
            if (it.x1 > it.x2 && it.y1 < it.y2 || it.x1 < it.x2 && it.y1 > it.y2){
                for ( i in it.minX()..it.maxX()) {
                    for ( p in it.maxY() downTo it.minY()) {
                        if ( p+i == it.maxY()+it.minX()){
                            tab[p][i] ++
                        }
                    }
                }
            }
        }
    }

    var cpt = 0

    tab.forEach{
        println()
        it.forEach{
            if (it != 0){
                print("$it")
            }else {
                print(".")
            }
            if ( it > 1 ){
                cpt ++
            }
        }
    }

    println("\n $cpt")
}

data class Coord (
    var x1 : Int = 0,
    var y1 : Int = 0,
    var x2 : Int = 0,
    var y2 : Int = 0,
){
    fun minX() : Int { return min(x1,x2) }
    fun maxX() : Int { return max(x1,x2) }
    fun minY() : Int { return min(y1,y2) }
    fun maxY() : Int { return max(y1,y2) }
}