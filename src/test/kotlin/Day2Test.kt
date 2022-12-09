import main.kotlin.Day2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {

    @Test
    fun part1() {
        val day2 = Day2()

        val ans = day2.part1()

        assertEquals(11666, ans)
    }

    @Test
    fun part2() {
        val day2 = Day2()

        val ans = day2.part2()

        assertEquals(12767, ans)
    }
}