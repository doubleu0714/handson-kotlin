fun main(args: Array<String>) {
    typeCase()
    wrapper()
    bitOperate()
    character()

    createArray()

    stringLiterals()
}

/**
 */
fun typeCase() {
    var intVar: Int = 150
    // 아래와 같이 암묵적인 widening은 제공되지 않음
    // var longVar: Long = intVar
    // 아래의 to... 함수를 사용해야함
    // 
    // toByte(): Byte
    // toShort(): Short
    // toInt(): Int
    // toLong(): Long
    // toFloat(): Float
    // toDouble(): Double
    // toChar(): Char
    var longVar = intVar.toLong()
    println("intVar = $intVar, longVar = $longVar")
}

fun wrapper() {
    val a: Int = 1000
    val b = a;
    var c: Int? = a // boxing and creat new Int? Object
    var d: Int? = a // boxing and creat new Int? Object
    var e: Int? = c
    println("a == b : ${a == b}, a === b : ${a === b}")
    println("a == c : ${a == c}, a === c : ${a === c}")
    println("c == d : ${c == d}, c === d : ${c === d}")
    println("c == e : ${c == e}, c === e : ${c === e}")
}

fun bitOperate() {   
    // shl(bits) – signed shift left (Java's <<)
    // shr(bits) – signed shift right (Java's >>)
    // ushr(bits) – unsigned shift right (Java's >>>)
    // and(bits) – bitwise and
    // or(bits) – bitwise or
    // xor(bits) – bitwise xor
    // inv() – bitwise inversion

    val a: Int = 10
    val b: Int = -10
    
    val shlResult1: Int = a shl 1
    val shlResult2: Int = b shl 1
    println("shlResult1: $shlResult1, shlResult2: $shlResult2")
    val shrResult1: Int = a shr 1
    val shrResult2: Int = b shl 1
    println("shrResult1: $shrResult1, shrResult2: $shrResult2")
    val ushrResult1: Int = a ushr 1
    val ushrResult2: Int = b ushr 1
    println("ushrResult1: $ushrResult1, ushrResult2: $ushrResult2")

}

fun character() {
    var str = "Test"
    var charArr = str.toCharArray()
    println(charArr)
    for(tmp in charArr) {
        println(tmp)
    }
}

fun createArray() {
    // arrayOf 함수와 Array 생성자로 가능하다.
    val tmp1 = arrayOf(1, 2, 3, 4, 5)
    val tmp2 = Array(5, {i -> i})

    tmp1.forEach { print(it) } 
    println()
    tmp2.forEach{ print(it) }
    println()
    // 기본 타입에 대한 array 형을 지원한다.
    var tmp3: IntArray = intArrayOf(1, 2, 3, 4, 5)
    tmp3.forEach{ i -> print(i) }
    println()
}

fun stringLiterals() {
    var text = """
                Hello
                World
    """.trimMargin()

    println(text);
}