package main.kotlin

import java.io.File

fun day4part1(): Int {
    val lines = File("src/main/resources/input4.txt").readLines()

    var count = 0

    lines.forEach() {
        val (lower1, upper1, lower2, upper2) = Regex("^(\\d+)-(\\d+),(\\d+)-(\\d+)$").find(it)!!.destructured

        val range1 = (lower1.toInt()..upper1.toInt()).toSet()
        val range2 = (lower2.toInt()..upper2.toInt()).toSet()
        if (range1.containsAll(range2) || range2.containsAll(range1)) count++
    }

    return count
}


fun day4part2(): Int {
    val lines = File("src/main/resources/input4.txt").readLines()

    var count = 0

    lines.forEach() {
        val (lower1, upper1, lower2, upper2) = Regex("^(\\d+)-(\\d+),(\\d+)-(\\d+)$").find(it)!!.destructured

        val range1 = (lower1.toInt()..upper1.toInt()).toSet()
        val range2 = (lower2.toInt()..upper2.toInt()).toSet()

        if (range1.intersect(range2).isNotEmpty()) count++
    }

    return count
}



fun main() {
    println("Day 4")
    println("Part 1: ${day4part1()}")
    println("Part 2: ${day4part2()}")
}