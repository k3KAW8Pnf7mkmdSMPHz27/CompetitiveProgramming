fun main() {
    var t = readLine()!!.toInt()
    while (t > 0) {
        var n = readLine()!!.toInt() - 1
        val x = readLine()!!.split(' ').map(String::toInt)
        var currentValue = x[n]
        n--
        var no = true
        while (n >= 0 && no) {
            val nextValue = x[n]
            if ((currentValue - nextValue)%2 == 0) {
                no = false
            }
            currentValue = nextValue
            n--
        }
        if (no) {
            println("NO")
        } else {
            println("YES")
        }

        t--
    }
}