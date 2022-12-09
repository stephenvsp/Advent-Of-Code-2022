import main.kotlin.Day1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test {

    @Test
    fun `day 1 part 1`() {
        val day1 = Day1()

        val ans = day1.part1()

        assertEquals(69836, ans)
    }

    @Test
    fun `day 1 part 2`() {
        val day1 = Day1()

        val ans = day1.part2()

        assertEquals(207968, ans)
    }
}
