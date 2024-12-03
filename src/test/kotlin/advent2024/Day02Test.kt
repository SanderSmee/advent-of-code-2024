package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    // Arrange
    private val input = """
		7 6 4 2 1
		1 2 7 8 9
		9 7 6 2 1
		1 3 2 4 5
		8 6 4 4 1
		1 3 6 7 9
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day02(input).solvePart1()

			assertThat(answer).isEqualTo(2)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(526)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day02(input).solvePart2()

			assertThat(answer).isEqualTo(4)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(566)
        }
    }
}
