package advent2024

/**
 * Advent of Code 2024, Day 1 - Historian Hysteria
 * Problem Description: http://adventofcode.com/2024/day/1
 */
class Day02(private val input: List<String>) {

    fun solvePart1(): Int = parse(input)
        .let { lists ->
            lists.count { isSafe(it) }
        }

    fun solvePart2(): Int = parse(input)
        .let { lists ->
            lists.count { isSafeDampened(it) }
        }

    private fun isSafeDampened(report: List<Int>): Boolean {
        return report.indices.any { removeThis ->
            isSafe(report.filterIndexed { index, _ -> removeThis != index })
        }
    }


    private fun isSafe(report: List<Int>): Boolean {
        val diffs = report.zipWithNext().map { (a, b) -> a - b }
        return diffs.all { it in 1..3 } || diffs.all { it in -3..-1 }
    }


    private fun parse(input: List<String>): List<List<Int>> {
        return input.map { l ->
            l.split(" ").map { it.toInt() }
        }
    }
}
