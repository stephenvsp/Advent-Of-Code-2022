import main.kotlin.Day3
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day3Test {

    @Test
    fun part1() {
        val day3 = Day3()

        val ans = day3.part1()

        assertEquals(8072, ans)
    }

    @Test
    fun part2() {
        val day3 = Day3()

        val ans = day3.part2()

        assertEquals(2567, ans)
    }
}