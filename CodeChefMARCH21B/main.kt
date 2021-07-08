import java.util.Scanner;

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    val t = read.nextInt();
    repeat(t) {
        val c = read.nextInt()
        val twoPowD = Integer.highestOneBit(c) shl 1
        var position = Integer.numberOfTrailingZeros(twoPowD)
        var a = 0
        var b = 0
        var first = true;
        while (position-- > 0) {
            //println("Loop")
            //println(position)
            val currentBit = 1 shl position
            //println(currentBit)
            //println((currentBit and c))
            //println(a)
            /*
            if ((currentBit and c) == 0) {
                a += currentBit
                b += currentBit
            } else {
                if ((a + currentBit)*b > (b + currentBit)*a) {
                    a += currentBit;
                } else {
                    b += currentBit;
                }
            }*/
            if ((currentBit and c) == 0)  {
                a += currentBit;
            } else if (first) {
                a += currentBit
                first = false
            }
        }
        b = a xor c

        //println(a)
        //println(b)
        //println(a xor b == c)
        println(a*b)
    }
}