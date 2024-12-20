package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val input = """
		3   4
		4   3
		2   5
		1   3
		3   9
		3   3
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day01(input).solvePart1()

			assertThat(answer).isEqualTo(11)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2086478)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day01(input).solvePart2()

			assertThat(answer).isEqualTo(31)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(24941624)
        }
    }
}
