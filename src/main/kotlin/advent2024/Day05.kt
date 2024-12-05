package advent2024

/**
 * Advent of Code 2024, Day 5 - Print Queue
 * Problem Description: http://adventofcode.com/2024/day/5
 */
class Day05(input: List<String>) {

	private val rules = parseRules(input)
	private val pages = parsePages(input)

	fun solvePart1(): Int = pages
		.filter (correctPages)
		.sumOf { p -> p[p.size / 2] }

	fun solvePart2(): Int = pages
		.filterNot(correctPages)
		.map (reorderPages)
		.sumOf { p -> p[p.size / 2] }

	private val correctPages: (List<Int>) -> Boolean = { p ->
		p.mapIndexed { index, i ->
			p.subList(index + 1, p.size).all { n ->
				rules.starting(i).map { it.second }.contains(n)
			}
				&& p.subList(0, index).all { n ->
				rules.ending(i).map { it.first }.contains(n)
			}
		}.all { it }
	}

	private val reorderPages: (List<Int>) -> List<Int> = { p ->
		val applicableRules = p.flatMap { n -> rules.starting(n) + rules.ending(n) }

		p.sortedWith(Orderer(applicableRules))
	}

	private fun parseRules(input: List<String>): List<Pair<Int, Int>> =
		input
			.filter { it.contains('|') }
			.map {
				val (left, right) = it.split('|')

				left.toInt() to right.toInt()
			}

	private fun parsePages(input: List<String>): List<List<Int>> =
		input.filter { it.contains(",") }
			.map { it.split(",").map { it.toInt() } }
			.toList()

	class Orderer(private val rules: List<Pair<Int, Int>>): Comparator<Int> {
		override fun compare(a: Int, b: Int): Int = when {
			rules.starting(a).map { it.second }.contains(b) -> -1
			rules.ending(a).map { it.first }.contains(b) -> 1
			else -> 0
		}

	}
}


fun List<Pair<Int, Int>>.starting(int: Int): List<Pair<Int, Int>> =
	filter { it.first == int }
fun List<Pair<Int, Int>>.ending(int: Int): List<Pair<Int, Int>> =
	filter { it.second == int }
