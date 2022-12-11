package main.kotlin

import java.io.File
import kotlin.collections.ArrayDeque

fun readFile(): List<String> = File("src/main/resources/input5.txt").readLines()

fun getContainers(): List<ArrayDeque<Char>> {
    val lines = readFile()

    val containers = listOf(ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>(), ArrayDeque<Char>())

    lines.takeWhile { it.isNotEmpty() }
        .dropLast(1)
        .forEach {

            for (i in 1..it.length step 4) {
                if (it[i].isLetterOrDigit()) {
                    containers[i / 4].add(it[i])
                }
            }
        }

    return containers
}

fun getInstructions(): List<List<Int>> {
    val lines = readFile()

    var instructions = mutableListOf<List<Int>>()

    lines.takeLastWhile { it.isNotEmpty() }
        .forEach {
            val (num, origin, destination) = Regex("^move (\\d+) from (\\d+) to (\\d+)$").find(it)!!.destructured
            instructions.add(listOf(num.toInt(), origin.toInt() - 1, destination.toInt() - 1))
        }
    return instructions
}

fun day5part1(): String {
    val containers = getContainers()
    val instructions = getInstructions()

    instructions.forEach { (num, origin, destination) ->
        repeat(num) {
            containers[destination].addFirst(containers[origin].removeFirst())
        }
    }
    return containers.map { it.first() }.joinToString("")
}

fun day5part2(): String {
    val containers = getContainers()
    val instructions = getInstructions()

    instructions.forEach { (num, origin, destination) ->

        var toMove = mutableListOf<Char>()
        repeat(num) {
            toMove.add(containers[origin].removeFirst())
        }
        toMove.reversed().forEach {
            containers[destination].addFirst(it)
        }
    }
    return containers.map { it.first() }.joinToString("")
}

fun main() {
    println("Day 5")
    println("Part 1: ${day5part1()}")
    println("Part 2: ${day5part2()}")
}