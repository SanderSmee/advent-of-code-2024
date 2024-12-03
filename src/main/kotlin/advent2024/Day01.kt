package advent2024

import kotlin.math.absoluteValue

/**
 * Advent of Code 2024, Day 1 - Historian Hysteria
 * Problem Description: http://adventofcode.com/2024/day/1
 */
class Day01(private val input: List<String>) {

    fun solvePart1(): Int = parse(input)
		.let { (left, right) ->
			left.sorted()
				.zip(right.sorted())
				.sumOf { (first, second) -> (first - second).absoluteValue }
		}

    fun solvePart2(): Int = parse(input)
		.let { (left, right) ->
			left.sumOf { l ->
				l * right.count { it == l }
			}
		}

    private fun parse(input: List<String>): Pair<List<Int>, List<Int>> {
		val a = mutableListOf<Int>()
		val b = mutableListOf<Int>()

		input.map { line ->
			a.add( line.substringBefore(" ").toInt() )
			b.add( line.substringAfterLast(" ").toInt() )
		}

		return a to b
    }
}
