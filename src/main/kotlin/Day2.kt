package main.kotlin

import java.io.File

class Day2 {

    //A rock B paper C scissors
    //X rock Y paper Z scissors
    val choiceScore = mapOf('A' to 1, 'B' to 2, 'C' to 3, 'X' to 1, 'Y' to 2, 'Z' to 3)

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

    val decisionScore = mapOf('X' to 0, 'Y' to 3, 'Z' to 6)

    fun part2(): Int {
        val lines = File("src/main/resources/input2.txt").readLines()

        return lines.sumOf {
            val opponent = it[0]
            val outcome = it[2]


            decisionScore[outcome]!! + evaluteDecision(opponent, outcome)
        }
    }

    fun evaluteDecision(opponent: Char, outcome: Char): Int {
        return when(opponent) {
            'A' -> when(outcome) {
                'X' -> 3
                'Y' -> 1
                else -> 2
            }
            'B' -> when(outcome) {
                'X' -> 1
                'Y' -> 2
                else -> 3
            }
            else -> when(outcome) {
                'X' -> 2
                'Y' -> 3
                else -> 1
            }
        }
    }
}