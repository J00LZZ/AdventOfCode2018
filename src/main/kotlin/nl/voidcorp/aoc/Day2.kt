package nl.voidcorp.aoc

class Day2 : DayBase(2) {
    override fun part1(list: List<String>): String {
        var twice = 0
        var trice = 0
        for (s in list) {

            val letters = mutableMapOf<Char, Int>()
            for (c in s) {
                if (letters[c] == null) {
                    letters[c] = 0
                }
                letters[c] = letters[c]!! + 1
            }
            if (letters.filterValues { it == 2 }.isNotEmpty()) {
                twice++
            }
            if (letters.filterValues { it == 3 }.isNotEmpty()) {
                trice++
            }
        }
        return "$twice * $trice = ${twice * trice}"
    }

    override fun part2(list: List<String>): String {
        val boxes = mutableSetOf<String>()
        for (s in list) {

            val letters = mutableMapOf<Char, Int>()
            for (c in s) {
                if (letters[c] == null) {
                    letters[c] = 0
                }
                letters[c] = letters[c]!! + 1
            }
            if (letters.filterValues { it == 2 }.isNotEmpty()) {
                boxes += s
            }
            if (letters.filterValues { it == 3 }.isNotEmpty()) {
                boxes += s
            }
        }
        var res = ""
        for (b in boxes) {
            for (s in boxes) {
                var changes = 0
                for (i in 0 until s.length){
                    if(b[i] != s[i]){
                        changes++
                    }
                }
                if (changes == 1){
                    for (i in 0 until s.length){
                        if(b[i] == s[i]){
                            res+=b[i]
                        }
                    }
                    return res
                }
            }
        }
        return res
    }
}

val day2 = DayBase(2, { TODO("NYE") }) {
    TODO("NYE")
}

fun DayBase(
    date: Int,
    part1: (List<String>) -> String,
    part2: (List<String>) -> String
) = object : DayBase(date) {
    override fun part1(list: List<String>): String = part1(list)
    override fun part2(list: List<String>): String = part2(list)
}
