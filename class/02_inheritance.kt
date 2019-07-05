abstract class Person(val name: String) {
    abstract fun hello()
}

open class Parent constructor(open val familyName: String): Person(familyName) {
    override fun hello() {
        println("Hello I'm $familyName")
    }
}

interface Greeting {
    fun hello() {
        println("Hello")
    }
}

// 아무것도 상속받지 않는다면 암묵적으로 Any 타입을 상속받는다
// 다중상속 안된다.
// kotlin에서는 overridable member에 대해서는 명시적으로 'open' modifier를 선언해야 한다.
// override 시에는 'override' modifier를 선언해야한다.
class Child constructor(val firstName: String, override val familyName: String) : Parent(familyName), Greeting {
    // override 후 하위 클래스가 더이상 override 하지 못하도록 하기 위해서는 final 을 사용한다.
    // final override fun hello() {
    override fun hello() {
        // println("Hello my name is final $firstName $familyName")
        println("Hello I'm $firstName $familyName")
    }

    fun helloParent() {
        // Parent class와 inerface에 같은 이름의 function이 있다면 suer<type> 으로 명시해 주어야함
        super<Parent>.hello()
        super<Greeting>.hello()
    }
}

fun main(args: Array<String>) {
    val me: Child = Child("Wonhyung", "Park")
    val brother: Parent = Child("Sunghun", "Park")
    val parent: Parent = Parent("Park")
    me.hello()
    brother.hello()
    me.helloParent()
    parent.hello()
}

