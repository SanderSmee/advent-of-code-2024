package advent2024

/**
 * Advent of Code 2024, Day 1 - Historian Hysteria
 * Problem Description: http://adventofcode.com/2024/day/1
 */
class Day03(private val input: String) {

    fun solvePart1(): Int = parse(input).sumOf { (a,b) -> a*b }

    fun solvePart2(): Int = "do()$input".split("""do\(\)""".toRegex())
		.map { it.split("""don't\(\)""".toRegex(), limit = 2)[0] }
		.flatMap { parse(it) }
		.sumOf { (a,b) -> a*b }

    private fun parse(input: String): List<Pair<Int,Int>> {
		val regex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()
		val matches = regex.findAll(input)
		return matches.map {
			r -> r.groupValues[1].toInt() to r.groupValues[2].toInt()
		}.toList()
    }
}
