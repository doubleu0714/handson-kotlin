// 패키지 선언은 소스파일 맨 위에 작성
package io.doubleu0714.kotlin

// 메인 함수
fun main(args: Array<String>) {
    println("Hello world!")
    println(function1(1, 2))
    println(function2(1, 2))
    println(function3(1, 2))
    println(function4(1, 2))
    localVariable()
    // 함수의 파라미터는 val 인듯..파라미터에 대해서 reassign을 할 수가 없음.
    // topLevelVarTest(topLevelVar)
    topLevelVariable()
}

// 함수 정의 
// fun 함수명(파라미터명: 파라미터타입): 리턴타입
fun function1(a: Int, b: Int): Int {
    return a + b
}

// 리턴 타입을 정의하지 않고 컴파일러가 추론할 수 있습니다.
fun function2(a: Int, b: Int) = a - b

// 리턴 값이 없는 경우 의미없는 타입을 정의할 수 있습니다.
fun function3(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

// 리턴 값이 없는 경우 생략할 수 있습니다.
fun function4(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

// Top Level 변수
// Top Level 의 val 변수는 선언과 동시에 초기화 해주어야 하는듯
val topLevelVal: String = "Top"
var topLevelVar: Int = 2

fun localVariable() {
    val a: Int = 1 // immutable variable is 'val'
    val b = 1 // 타입 추론이 가능함
    val c: Int // 나중에 한번 초기화 가능. c 변수가 사용되기전에는 초기화 되어야함. 

    c = 2
    topLevelVar = 3

    // variable 'c' must be initialized
    println("a = $a, b = $b, c = $c")

    println("topLevelVal = $topLevelVal, topLevelVar = $topLevelVar")
}

fun topLevelVarTest(temp: Int) {
    // 파라미터를 reassign 할 수 없다.
    // temp = 1000;
}

fun topLevelVariable() {
    // topLevelVar 값은 다른 func에서 수정한 값으로 받게된다.
    println("topLevelVal = $topLevelVal, topLevelVar = $topLevelVar")
}