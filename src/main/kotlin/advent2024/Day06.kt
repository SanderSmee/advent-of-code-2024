package advent2024

import kotlin.enums.enumEntries

/**
 * Advent of Code 2024, Day 6 - Guard Gallivant
 * Problem Description: http://adventofcode.com/2024/day/6
 */
class Day06(private val input: List<String>) {

	fun solvePart1(): Int {
		val start = input.find('^')

		return input
			.toMutableList()
			.safeStep(start.first, start.second, Arrow.UP )

	}

	fun solvePart2(): Int {
		val start = input.find('^')

		return input
			.toMutableList()
			.safeBlock(start.first, start.second, Arrow.UP )
	}

	companion object {
		val CORNERS = listOf(-1 to -1, -1 to 1, 1 to 1, 1 to -1)
		val PRIMARY = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

		enum class Arrow(val vector: Pair<Int, Int>, val mark: Char) {
			UP(0 to -1, '|'), RIGHT(1 to 0, '-'), DOWN(0 to 1, '|'), LEFT(-1 to 0, '-');

			fun next(): Arrow {
				val arrows = enumEntries<Arrow>()
				val next = if (this.ordinal +1 < arrows.size) this.ordinal + 1 else 0
				return arrows[next]
			}
		}
	}
}

fun List<String>.safeAt(x: Int, y: Int): Char =
	if (y in indices && x in this[y].indices) this[y][x] else ' '

fun List<String>.find(start: Char): Pair<Int, Int> {
	var result: Pair<Int, Int>? = null
	for (y in indices) {
		for (x in this[y].indices) {
			if (this[y][x] == start) { result = x to y }
		}
	}
	return result!!
}

tailrec fun List<String>.peekNext(x:Int, y:Int,dir:Day06.Companion.Arrow): Boolean {
	val next = safeAt(x + dir.vector.first, y + dir.vector.second)

	return when {
		next == '#' && this[y][x] in setOf('+', '-', '|') -> true
//		next == '#' && safeAt(x + dir.next().vector.first, y + dir.next().vector.second) in setOf(dir.next().mark, '+') -> true
		next == ' ' -> false
		next == '#' -> false
		else -> peekNext(x + dir.vector.first, y + dir.vector.second, dir)
	}
}

fun List<String>.peekRight(x:Int, y:Int, dir:Day06.Companion.Arrow): Boolean {
	val right = dir.next()

	return peekNext(x, y, right)
}

tailrec fun MutableList<String>.safeStep(x: Int, y: Int, dir: Day06.Companion.Arrow, count: Int = 1): Int {
	val next = dir.vector
	return when {
		safeAt(x + next.first, y+next.second) == ' ' -> count
		safeAt(x + next.first, y + next.second) == '#' -> safeStep(x , y, dir.next(), count)
		else -> {
			val inc = if (this[y][x] == 'X') count else count + 1
			this[y] = this[y].putAt(x, 'X')
			safeStep(x + next.first, y + next.second, dir, inc)
		}
	}
}

tailrec fun MutableList<String>.safeBlock(x: Int, y: Int, dir: Day06.Companion.Arrow, count: Int = 0): Int {
	val next = dir.vector
	return when {
		safeAt(x + next.first, y+next.second) == ' ' -> count
		safeAt(x + next.first, y + next.second) == '#' -> {
			this[y] = this[y].putAt(x, '+')
			safeBlock(x , y, dir.next(), count)
		}
		else -> {
			val inc = if (peekRight(x, y, dir)) count+1 else count

			this[y] = when {
				this[y][x] == '+' -> this[y]
				this[y][x] == '.' -> this[y].putAt(x, dir.mark)
				this[y][x] != dir.mark -> this[y].putAt(x, '+')
				else -> this[y].putAt(x, dir.mark)
			}
			safeBlock(x + next.first, y + next.second, dir, inc)
		}
	}
}



fun String.putAt(index:Int, char: Char): String {
	val builder = StringBuilder(this)
	builder[index] = char
	return builder.toString()
}
