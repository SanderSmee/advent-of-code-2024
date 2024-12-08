package advent2024

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

