package main.kotlin

import java.io.File
import java.util.*

class Day1 {

    private fun readFile(): List<String> {
         return File("src/main/resources/input1.txt").readLines()

    }

    fun part1(): Int {
        val elves = readFile()

        return elves.splitBy { it == "" }.maxOf { strings -> strings.sumOf { it.toInt() } }
    }

    fun part2(): Int {
        val elves = readFile()

        return elves.splitBy { it == "" }
            .map { strings -> strings.sumOf { it.toInt() }}
            .sortedDescending()
            .take(3)
            .sum()
    }

    private fun <E> List<E>.splitBy(predicate: (E) -> Boolean): List<List<E>> =
        this.fold(mutableListOf(mutableListOf<E>())) { acc, element ->
            if (predicate.invoke(element)) {
                acc += mutableListOf<E>()
            } else {
                acc.last() += element
            }
            acc
        }

}