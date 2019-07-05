interface MyInterface {
    val valProp1: String
    // val valProp2: String = "ABC" // 이렇게 초기화 할 수 없다.
    val valProp2: String
        get() = "ABC"

    fun defaultMethod(name: String) {
        println("called by $name at interface")
    }

    fun method1(name: String)
}

class MyClass : MyInterface {
    override val valProp1: String = "Test"
    override fun method1(name: String) {
        println("called by $name at implementation")
    }
}

fun main(args: Array<String>) {
    val testClass: MyInterface = MyClass()
    println("testClass.valProp1 = ${testClass.valProp1}")
    println("testClass.valProp2 = ${testClass.valProp2}")
    testClass.defaultMethod("Won")
    testClass.method1("Won")
}