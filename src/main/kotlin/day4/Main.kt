package day4

import java.io.File
import kotlin.streams.toList

fun main(args: Array<String>) {
    Jeu()
}
class Jeu {

    private lateinit var grilles : List<Grille>

    constructor() {
        val file = File("D:/Bureau/AdventOfCode/src/main/resources/day4/input.txt")
        var list = file.readText().split("\r\n\r\n")
        var values = list[0].split(",").map { x -> x.toInt() }
        println(values)

        var str = list.subList(1, list.size)
        var nbGrille = str.size
        this.grilles = List(nbGrille) { Grille() }

        for (i in 0 until str.size) {
            var cases = str[i].replace("\r\n", " ").split(" +".toRegex()).filter { x -> x != "" }
            cases.forEachIndexed { index, it ->
                grilles[i].lst[index].value = it.toInt()
            }
        }

        var grilletmp : ArrayList<Grille>

        values.forEach{ n ->
            grilletmp = arrayListOf()
            grilles.forEach { grille ->
                grille.lst.forEach { case ->
                    if (case.value == n) {
                        case.checked = true
                    }
                }
                if (grille.lineComplete()) {
                    println(grille.sum().toString() + " value : " + n)
                    println("result : " + grille.sum() * n)
                    grilletmp.add(grille)
                }
            }
            grilletmp.forEach{
                grilles = grilles.filter { x -> x != it }
            }
        }
    }



    fun grillesChecked() : Boolean {
        grilles.forEach{
            if ( it.lineComplete()) return true
        }
        return false
    }
}

class Grille {
    val lst : List<Case> = List(25) { Case() }

    fun lineComplete() : Boolean {
        var cpt = 0;
        lst.forEachIndexed{ index , it ->
            if ( index % 5 == 0) cpt = 0
            if ( it.checked ){
                cpt ++
            }
            if (cpt == 5) return true
        }

        cpt = 0
        for ( i  in  0..4 ){
            for ( t in 0..4){
                if ( lst[i+(t*5)].checked ){
                    cpt ++
                }
                if (cpt == 5 )return true
            }
            cpt = 0
        }

        return false;
    }

    fun sum() : Int{
        var sum = 0
        lst.forEach{
            if ( !it.checked) sum += it.value
        }
        return sum
    }
}

data class Case constructor(
    var value : Int = 0,
    var checked : Boolean = false
)