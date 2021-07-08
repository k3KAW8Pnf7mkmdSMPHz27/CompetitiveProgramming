fun main() {
    var t = readLine()!!.toInt()
    while (t > 0) {
        var answer = 0
        var (n, k) = readLine()!!.split(' ').map(String::toInt)
        while (n > 0) {
            var (l, r) = readLine()!!.split(' ').map(String::toInt)
            if (l <= k) {
                l = l.coerceAtLeast(k)
                answer = Math.max(answer, r - l + 1)
            }
            n--
        }
        println(answer)
        t--
    }
}