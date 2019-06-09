// 패키지 선언은 소스파일 맨 위에 작성
package io.doubleu0714.kotlin

// 메인 함수
fun main(args: Array<String>) {
    println("Hello world!")
    println("function1(1, 2) = ${function1(1, 2)}")
    println("function2(1, 2) = ${function2(1, 2)}")
    println("function3(1, 2) = ${function3(1, 2)}")
    println("function4(1, 2) = ${function4(1, 2)}")
    println("function2(1, 2) = ${function2(1, 2)}")
    // 디폴트 값이 설정 되어있어서 인자값을 안넣어 주어도 실행가능
    println("function5() = ${function5()}")
    // 맨 앞 파라미터에 인자값이 설정되고 그 뒤의 파라미터는 디폴트 값으로 설정됨
    println("function5(5) = ${function5(5)}")
    // 인자값을 명시적으로 표현할 수 있다.
    println("function5(b=5) = ${function5(b=5)}")
    println("function6(Hi) = ${function6(b="HI")}")
    println("localVariable = ${localVariable()}")
    // 함수의 파라미터는 val 인듯..파라미터에 대해서 reassign을 할 수가 없음.
    // topLevelVarTest(topLevelVar)
    println("topLevelVariable is called!!!====================")
    topLevelVariable()

    // 문자열안에 ${} 표현식으로 함수 호출도 가능함
    println("ifExpressions1(1, 2) = ${ifExpressions1(1, 2)}")
    println("ifExpressions1(3, 2) = ${ifExpressions1(3, 2)}")
    println("ifExpressions1(2, 2) = ${ifExpressions1(2, 2)}")
    println("ifExpressions2(1, 2) = ${ifExpressions2(1, 2)}")
    println("ifExpressions2(3, 2) = ${ifExpressions2(3, 2)}")
    println("ifExpressions2(2, 2) = ${ifExpressions2(2, 2)}")

    println("nullCheck1 = ${nullCheck1("test")}")
    println("nullCheck1 = ${nullCheck1("13413")}")

    typeCasting("Test"); 
    typeCasting(null);    
    typeCasting(111);    
    typeCasting("TestValue"); 


    loopTest()
    whenTest("test")
    whenTest("hello")

    rangeTest("apple")
    rangeTest("wonhyung")
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

// 파라미터에 디폴트 값을 설정
fun function5(a: Int = 10, b: Int = 100) {
    println("a = $a, b = $b")
}

// 파라미터에 디폴트 값을 설정
fun function6(a: Int = 10, b: String = "Test") {
    println("a = $a, b = $b")
}

// Top Level 변수
val topLevelVal: String = "Top"
var topLevelVar: Int = 2

fun localVariable() {
    val a: Int = 1 // immutable variable is 'val'
    val b = 1 // 타입 추론이 가능함
    val c: Int // 나중에 한번 초기화 가능. c 변수가 사용되기전에는 초기화 되어야함. 
    var d: Int = 1

    c = 2
    topLevelVar = 3

    // variable 'c' must be initialized
    println("a = $a, b = $b, c = $c, d = $d")

    println("topLevelVal = $topLevelVal, topLevelVar = $topLevelVar")
}

fun topLevelVarTest(temp: Int) {
    // 파라미터를 reassign 할 수 없다.
    // temp = 1000;
    // println(temp)
}

fun topLevelVariable() {
    // topLevelVar 값은 다른 func에서 수정한 값으로 받게된다.
    println("topLevelVal = $topLevelVal, topLevelVar = $topLevelVar")
}

fun ifExpressions1(a: Int, b: Int): Int {
    if(a > b) {
        return a
    } else if(b > a) {
        return b
    }
    return a + b
}

fun ifExpressions2(a: Int, b: Int) = if(a > b) a else if(b > a) b else a + b

// 리턴 타입에 nullable을 표시 -> '?'
// 리턴 타입이 Not null 타입(Int)일 때 null을 리턴하면 에러 발생
fun nullCheck1(str: String): Int? {
    
    val result = str.toIntOrNull()

    // automatically cast to non-nullable
    if(result is Int?) {
        println("result is Int?")
    }
    if(result is Int) {
        println("result is Int")
    }
    if(result == null) {
        println("str = ${str} can't convert to Int type")
        // null point exception은 발생하지 않으나 실행되지 않는것으로 보임
        result.toString()
    }
    if(result is Int?) {
        println("result is Int?")
    }
    if(result is Int) {
        println("result is Int")
    }

    return result;
}

fun typeCasting(obj: Any?) {
    println("obj is ${obj}")
    // 아직은 형변환이 되기 전 Any? 타입이므로 length 가 선언되지 않았다고 에러발생
    // println("obj length is ${obj.length}")
    if(obj !is String) {
        println("obj is not String type")
    }
    if(obj is String) {
        // automatically casting to string
        println("obj length is ${obj.length}")
    }

    // && 연산 이전에 타입 검증이 되므로 자동 형변환 된다. 
    // 그래서 아래와 같이 사용할 수 있다.
    if(obj is String && obj.length > 4) {
        println("obj is long string")
    }
}

fun loopTest() {
    val items = listOf('a', "Apple", 1000, 1000.543)
    for (item in items) {
        println(item)
    }

    // index 값을 가져오기 위한 방법
    for (index in items.indices) {
        println("index $index and ${items[index]}")
    }

    var index = 0;

    while(index < items.size) {
        println(items[index])
        index++;
    }
}

fun whenTest(obj: Any) {
    // 조건에 가장 먼저 맞는 로직이 실행됨
    // hello String 문자열이 들어오면 "is String" 이 아닌 "hello"가 출력됨
    when (obj) {
        1 -> println("1")
        "hello" -> println("hello")
        is String -> println("is String")
        !is String -> println("isn't String")
        else -> println("Unknown")
    }
}

fun rangeTest(item: String) {
    val items = listOf("apple", "orange", "kiwi", "kimchi")
    
    if(item in items) {
        println("Find ${item}")
    } else {
        println("Can't Find ${item}")
    }

    if(0 in 1..10) {
        println("0")
    } else {
        println("00000")
    }

    // 1보다 크거나 같고 10보다 작거나 같은 범위를 2씩 증가해서 출력
    for (x in 1..10 step 2) {
    print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}