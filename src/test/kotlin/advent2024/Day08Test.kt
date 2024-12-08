package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day ")
class Day08Test {

    // Arrange
    private val input = """
............
........0...
.....0......
.......0....
....0.......
......A.....
............
............
........A...
.........A..
............
............
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day08(input).solvePart1()

			assertThat(answer).isEqualTo(14)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(357)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day08(input).solvePart2()

			assertThat(answer).isEqualTo(34)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1266)
        }
    }
}
