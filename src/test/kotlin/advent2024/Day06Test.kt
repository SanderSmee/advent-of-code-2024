package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    // Arrange
    private val input = """
....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#...
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day06(input).solvePart1()

			assertThat(answer).isEqualTo(41)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4988)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day06(input).solvePart2()

			assertThat(answer).isEqualTo(6)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1016)
        }
    }
}
