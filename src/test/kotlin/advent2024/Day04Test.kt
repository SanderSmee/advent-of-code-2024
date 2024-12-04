package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    // Arrange
    private val input = """
		MMMSXXMASM
		MSAMXMSMSA
		AMXSXMAAMM
		MSAMASMSMX
		XMASAMXAMM
		XXAMMXXAMA
		SMSMSASXSS
		SAXAMASAAA
		MAMMMXMMMM
		MXMXAXMASX
        """.trimIndent().lines()

	// Arrange
    private val input2 = """
.M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
..........
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day04(input).solvePart1()

			assertThat(answer).isEqualTo(18)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2454)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day04(input2).solvePart2()

			assertThat(answer).isEqualTo(9)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1858)
        }
    }
}
