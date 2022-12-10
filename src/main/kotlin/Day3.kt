package main.kotlin

import java.io.File

class Day3 {

    fun part1(): Int {
        val lines = File("src/main/resources/input3.txt").readLines()

        return lines.sumOf {
            val mid = it.length / 2
            val first = it.substring(0, mid)
            val second = it.substring(mid, it.length)

            val shared = first.toSet().intersect(second.toSet()).first()

            val code = shared.code

            if (shared.isUpperCase()) {
                code - 38
            }
            else {
                code - 96
            }
        }
    }

    fun part2(): Int {
        val lines = File("src/main/resources/input3.txt").readLines()

        return lines.chunked(3).sumOf{ (a, b, c) ->

            val shared = a.toSet().intersect(b.toSet().intersect(c.toSet())).first()

            if (shared.isUpperCase()) shared - 'A' + 27 else shared - 'a' + 1

        }



    }
}