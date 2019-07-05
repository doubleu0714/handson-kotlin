class Person {
    var name: String? = null
}
fun main(args: Array<String>) {
    returnTest()
    breakAndContinueWithLabel()
    returnWithLabel1()
    returnWithLabel2()
}

fun returnTest() {
    val person = Person()
    val s = person.name ?: return /*  return 구문을 만나면 함수에서 빠져나간다. */
    println("????")
    println("s = $s")
}

fun breakAndContinueWithLabel() {
    testlabel@ for(i in 1 until 100) {
    // for(i in 1 until 100) {
        print("$i : ")
        for(j in 1 until 100 step i) {
            if(i % 2 == 0) {
                print("skip")
                // label을 사용하면 원하는 루프를 break 할 수 있다.
                // label을 사용하지 않으면 내부 루프에 대해서만 break 된다.
                break@testlabel
                // break 
            }
            print("${j} ");
        }
        println()
    }
    println()
    testlabel@ for(i in 1 until 100) {
    // for(i in 1 until 100) {
        print("$i : ")
        for(j in 1 until 100 step i) {
            if(i % 2 == 0) {
                println()
                continue@testlabel
                // continue
            }
            print("${j} ");
        }
        println()
    }
}

fun returnWithLabel1() {
    listOf(1,2,3,4,5).forEach {
        if(it == 3) return
        println(it)
    }
    println("Hello??")
}

fun returnWithLabel2() {
    listOf(1,2,3,4,5).forEach test@{
        if(it == 3) return@test
        println(it)
    }
    println("Hello??")
}