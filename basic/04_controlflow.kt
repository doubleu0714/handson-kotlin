
fun main(args: Array<String>) {
    val a = 10
    val b = 20
    // if 표현식 if 혹은 else if 혹은 else 절의 마지막은 return 할 값이다.
    val c = if (a > b) a else b 
    println("c = $c")

    // when 표현식
    val x = 10
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }
    // 아래와 같이 or 로 표현 가능하다.
    println()
    when (x) {
        1, 10 -> print("x == 1 or 10")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }
    // 아래와 같이 or 로 표현 가능하다.
    println()
    var s = "100"
    when (x) {
        s.toInt() -> print("s encodes x")
        else -> print("s does not encode x")
    }
    
    val validNumbers = arrayOf(1, 3, 5, 7, 9)
    println()
    // range도 사용 가능함
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    println()
    val tmp = "prefixTest"
    println("hasPrefix(x) = ${hasPrefix(x)}")
    println("hasPrefix(tmp) = ${hasPrefix(tmp)}")

    // range 표현식으로 수행하는 for loop
    for (i in 1..3) {
        println(i)
    }
    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    // index 값과 함께하는 for loop
    var array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in array.indices) {
        println(array[i])
    }
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix") // is String 검사 통과시 자동 형변환이 수행되므로 별도의 형변환이 필요하지 않다.
    else -> false
}