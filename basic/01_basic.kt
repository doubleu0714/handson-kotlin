package io.doubleu0714.kotlin

// DTO 클래스 만들기
// 아래와 같이 data 키워드를 붙여서 만든다.
// 자동으로 getter, setter, equals, hashCode, toString, copy, component1()... 함수를 생성한다.
data class Person(val name: String, var age: Int)

fun main(args: Array<String>) {
    var person = Person("Wonhyung", 10)
    println(person.toString())
    // 아래는 val 변수 이므로 reassign 할 수 없음
    // person.name = "못바꿈"
    person.age = 100
    println(person.toString())


    filterTest(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    mapTest()
    
    handleNull("Test")
    handleNull(null)

    testExtension()
}

fun filterTest(items: List<Int>) {
    val biggerThen5 = items.filter{x -> x > 5}
    println(biggerThen5)
}

fun mapTest() {
    var testMap = mapOf(1 to "A", 2 to "B")
    println("testMap = ${testMap}")
    println("testMap[1] = ${testMap[1]}")
}

fun handleNull(str: String?) {
    println("str = $str")
    // nullable 타입 (String?)을 그냥 사용하면 아래와 같은 에러발생
    // error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // println("str.length = ${str.length}")
    println("str?.length = ${str?.length}")
    println("str?.length ?: -1 = ${str?.length ?: -1}")

    str?.let {
        println("let statement execute when str is not null")
    } ?: println("statement execute when str is null")
}

// String에 test 함수를 extension
fun String.test(): String {
    return "Hello"
}

fun testExtension() {
    println("Test".test())
}

