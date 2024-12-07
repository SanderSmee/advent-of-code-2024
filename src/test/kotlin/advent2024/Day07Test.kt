package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {

    // Arrange
    private val input = """
190: 10 19
3267: 81 40 27
83: 17 5
156: 15 6
7290: 6 8 6 15
161011: 16 10 13
192: 17 8 14
21037: 9 7 18 13
292: 11 6 16 20
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day07(input).solvePart1()

			assertThat(answer).isEqualTo(3749)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2941973819040)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day07(input).solvePart2()

			assertThat(answer).isEqualTo(11387)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(0)
        }
    }
}
