package advent2024

import com.github.shiguruikai.combinatoricskt.combinations


/**
 * Advent of Code 2024, Day 8 - Resonant Collinearity
 * Problem Description: http://adventofcode.com/2024/day/8
 */
class Day08(private val input: List<String>) {

	fun solvePart1(): Int = parse(input)
		.findSameAntenna()
		.asSequence()
		.flatMap { (_, p) ->
			p.combinations(2)
				.map { it.antinodes() }
		}
		.flatten()
		.toSet()
		.count()

	fun solvePart2(): Int = parse(input)
		.findSameAntenna()
		.asSequence()
		.flatMap { (_, p) ->
			p.combinations(2)
				.map { it.resonantAntinodes() }
		}
		.flatten()
		.toSet()
		.count()

	private fun parse(input: List<String>): List<CharArray> =
		input.map { it.toCharArray() }

	private fun List<CharArray>.findSameAntenna(): Map<Char, List<Point2D>> =
		flatMapIndexed { x, row ->
			row.mapIndexed { y, c ->
				if (c.isLetterOrDigit()) c to Point2D(x, y) else null
			}
		}
			.filterNotNull()
			.groupBy({ it.first }, { it.second })
			.filter { (_, p) -> p.size != 1 }

	private fun List<Point2D>.antinodes(): List<Point2D> {
		this.sortedWith(Orderer())
		val (a, b) = this

		val offX = b.x - a.x
		val offY = b.y - a.y

		return listOf(
			Point2D(a.x - offX, a.y - offY),
			Point2D(b.x + offX, b.y + offY)
		).filter { p -> input.safeAt(p.x, p.y) != ' ' }
	}

	private fun List<Point2D>.resonantAntinodes(): List<Point2D> {
		this.sortedWith(Orderer())
		val (a, b) = this

		val offX = b.x - a.x
		val offY = b.y - a.y

		val result = mutableListOf(a, b)

		var a2 = Point2D(a.x - offX, a.y - offY)
		while (input.safeAt(a2.x, a2.y) != ' ') {
			result.add(a2)
			a2 = Point2D(a2.x - offX, a2.y - offY)
		}
		var b2 = Point2D(b.x + offX, b.y + offY)
		while (input.safeAt(b2.x, b2.y) != ' ') {
			result.add(b2)
			b2 = Point2D(b2.x + offX, b2.y + offY)
		}

		return result
	}

	class Orderer() : Comparator<Point2D> {
		override fun compare(a: Point2D, b: Point2D): Int {
			val rowComp = a.y.compareTo(b.y)
			return when {
				rowComp != 0 -> rowComp
				else -> a.x.compareTo(b.x)
			}
		}
	}

}
