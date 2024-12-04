package advent2024

/**
 * Advent of Code 2024, Day 4 -
 * Problem Description: http://adventofcode.com/2024/day/4
 */
class Day04(input: List<String>) {

	val matrix = parse(input)

	fun solvePart1(): Int {
		val xmas = arrayOf('M','A','S')
		var sum = 0

		for (y in matrix.indices) {
			for (x in matrix[y].indices) {
				val letter = matrix[x][y]

				if (letter == 'X') {
					sum += Fixed.entries.count { d ->
						xmas.indices.all { lt ->
							val dir = d * (lt+1)

							(x + dir.x in 0..<matrix[y].size && y + dir.y in 0..<matrix.size)
								&& matrix[x+dir.x][y+dir.y] == xmas[lt]
						}
					}
				}
			}
		}
		return sum
	}

	fun solvePart2(): Int {
		val cross = listOf(
			Fixed.UP_LEFT to Fixed.DOWN_RIGHT,
			Fixed.UP_RIGHT to Fixed.DOWN_LEFT
		)

		var sum = 0
		for (y in 1..<matrix.size -1) {
			for (x in 1..<matrix[y].size -1) {
				val letter = matrix[x][y]

				if (letter == 'A' &&
					cross.all { (a, b) ->
						listOf(
							matrix[x+a.x][y+a.y],
							matrix[x+b.x][y+b.y],
						).sorted() == listOf('M', 'S')
					})
				{
					sum++
				}
			}
		}
		return sum

	}

	private fun parse(input: List<String>): Array<CharArray> {

		return input.map { line -> line.toCharArray() }.toTypedArray()

	}
}

sealed interface Direction {
	val x: Int
	val y: Int
}
data class Flexed(override val x: Int, override val y: Int) : Direction {
}
enum class Fixed(override val x: Int, override val y: Int): Direction {
	UP_LEFT(-1, -1),
	UP(0,-1),
	UP_RIGHT(1, -1),
	RIGHT(1, 0),
	DOWN_RIGHT(1, 1),
	DOWN(0,1),
	DOWN_LEFT(-1, 1),
	LEFT(-1, 0);

	operator fun times(int: Int): Direction = Flexed(x * int, y * int)
}
