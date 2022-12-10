package main.kotlin

import java.io.File

fun day4part1(): Int {
    val lines = File("src/main/resources/input4.txt").readLines()

    return lines.count {
        val (lower1, upper1, lower2, upper2) = Regex("^(\\d+)-(\\d+),(\\d+)-(\\d+)$").find(it)!!.destructured

        val range1 = (lower1.toInt()..upper1.toInt()).toSet()
        val range2 = (lower2.toInt()..upper2.toInt()).toSet()

        range1.containsAll(range2) || range2.containsAll(range1)
    }
}


fun day4part2(): Int {
    val lines = File("src/main/resources/input4.txt").readLines()


    return lines.count {
        val (lower1, upper1, lower2, upper2) = Regex("^(\\d+)-(\\d+),(\\d+)-(\\d+)$").find(it)!!.destructured

        val range1 = (lower1.toInt()..upper1.toInt()).toSet()
        val range2 = (lower2.toInt()..upper2.toInt()).toSet()

        range1.intersect(range2).isNotEmpty()
    }
}



fun main() {
    println("Day 4")
    println("Part 1: ${day4part1()}")
    println("Part 2: ${day4part2()}")
}