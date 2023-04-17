package pro_12951

import java.util.Deque
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class Solution2 {
    fun solution(s: String): String {
        val answer = StringBuilder()

        val dq: Deque<Char> = LinkedList()

        for (c in s) {
            if (dq.isEmpty()) dq.addLast(c.uppercaseChar())
            else {
                if (c == ' ') {
                    dq.addLast(' ')
                }

                if (c.isLetter() || c.isDigit()) {
                    if (dq.peekLast() == ' ') {
                        dq.addLast(c.uppercaseChar())
                    } else {
                        dq.addLast(c.lowercaseChar())
                    }
                }
            }
        }

        dq.forEach { answer.append(it) }

        return answer.toString()
    }
}

fun main() {
    val s = Solution2()
    println(s.solution("1   2 3 4"))
}