package main.kotlin

import java.io.File

class Day2 {

    //A rock B paper C scissors
    //X rock Y paper Z scissors
    val choiceScore = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)

    fun part1(): Int {
        val lines = File("src/main/resources/input2.txt").readLines()

        return lines.sumOf {
            val opponent = it[0]
            val me = it[2]

            choiceScore[me]!! + evaluateRound(me, opponent)
        }
    }

    fun evaluateRound(me: Char, opponent: Char): Int {
        return when(me) {
            'X' -> when(opponent) {
                'A' -> 3
                'B' -> 0
                else -> 6
            }
            'Y' -> when(opponent) {
                'A' -> 6
                'B' -> 3
                else -> 0
            }
            else -> when(opponent) {
                'A' -> 0
                'B' -> 6
                else -> 3
            }
        }
    }


    fun part2(): Int {
        return 0
    }
}