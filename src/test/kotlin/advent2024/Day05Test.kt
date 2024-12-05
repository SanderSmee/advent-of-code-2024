package advent2024

import advent2024.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    // Arrange
    private val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

		@Test
		fun `Matches example`() {
			val answer = Day05(input).solvePart1()

			assertThat(answer).isEqualTo(143)
		}

		@Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4578)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

		@Test
		fun `Matches example`() {
			val answer = Day05(input).solvePart2()

			assertThat(answer).isEqualTo(123)
		}

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(-1)
        }
    }
}
