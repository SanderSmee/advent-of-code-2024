package advent2024

import advent2024.Resources.resourceAsListOfString
import advent2024.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day03Test {

    // Arrange
    private val input = """
		xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
        """.trimIndent()

	private val input_part2 = """
		xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
	""".trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day03(input).solvePart1()

			assertThat(answer).isEqualTo(161)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsText("day03.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(175015740)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day03(input_part2).solvePart2()

			assertThat(answer).isEqualTo(48)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsText("day03.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(112272912)
        }
    }
}
