package main.kotlin

import java.io.File

fun day4part1(): Int {
    val lines = File("src/main/resources/input4.txt").readLines()

    var count = 0

    lines.forEach() {
        val (lower1, upper1, lower2, upper2) = Regex("^(\\d+)-(\\d+),(\\d+)-(\\d+)$").find(it)!!.destructured

        if (contains((lower1.toInt()..upper1.toInt()).toSet(), (lower2.toInt()..upper2.toInt()).toSet())) count++
    }

    return count
}

fun contains(range1: Set<Int>, range2: Set<Int>): Boolean {

    if (range1.containsAll(range2)) return true
    if (range2.containsAll(range1)) return true

    return false
}

fun day4part2(): Int {
    return 0
}

fun main() {
    println("Day 4")
    println("Part 1: ${day4part1()}")
    println("Part 2: ${day4part2()}")
}