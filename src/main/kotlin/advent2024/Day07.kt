package advent2024

import com.github.shiguruikai.combinatoricskt.permutationsWithRepetition

/**
 * Advent of Code 2024, Day 7 - Bridge Repair
 * Problem Description: http://adventofcode.com/2024/day/7
 */
class Day07(private val input: List<String>) {

	fun solvePart1(): Long = parse(input)
		.filter { eq -> isCorrect(eq, listOf('+', '*')) }
		.sumOf { it.first }

	fun solvePart2(): Long = solvePart1() + parse(input)
		.filterNot { eq -> isCorrect(eq, listOf('+', '*')) }
		.filter { eq -> isCorrect(eq, listOf('+', '*', '|')) }
		.sumOf { it.first }

	private fun isCorrect(eq: Pair<Long, List<Long>>, operations: List<Char>): Boolean {
		val ops =
			operations.permutationsWithRepetition(eq.second.size - 1)

		return ops.any { guess ->
			eq.first == eq.second.reduceIndexed { index, acc, i ->
				calc (guess[index - 1], acc, i )
			}
		}
	}

	fun calc(op: Char, a: Long, b: Long): Long {
		return when (op) {
			'+'	-> a + b
			'*' -> a * b
			'|' -> "$a$b".toLong()
			else -> 0
		}
	}

	fun parse(input: List<String>):List<Pair<Long, List<Long>>> {
		return input.map { row ->
			row.split(": ").let { pair ->
				pair[0].toLong() to pair[1].split(" ").map { it.toLong() }
			}
		}
	}
}
