package day8

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.streams.toList


fun main(args: Array<String>) {

    val file = File("D:/Bureau/AdventOfCode/src/main/resources/day7/input.txt")

    val lst = file.bufferedReader().lines().toList()
    val numbers = lst[0].split(",").map { x -> x.toInt() }.sorted()

    var mediane = 0.0;

    if ( numbers.size%2 == 0){
        mediane = (numbers[numbers.size/2] + numbers[numbers.size/2 - 1])/2.0;
    }else{
        mediane = numbers[numbers.size/2].toDouble();
    }

    println(mediane)

    var sum = 0.0
    numbers.forEach{
        sum += abs(it-mediane)
    }

    println(sum)


}

