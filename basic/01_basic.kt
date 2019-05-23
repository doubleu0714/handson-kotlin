package io.doubleu0714.kotlin

data class Person(val name: String, var age: Int)

fun main(args: Array<String>) {
    var person = Person("원형", 10)
    println(person.toString())
    // 아래는 val 변수 이므로 reassign 할 수 없음
    // person.name = "못바꿈"
    person.age = 100
    println(person.toString())
}