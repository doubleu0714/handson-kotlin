// class 정의 부분
// 기본 생성자는 class선언 라인에 같이 기입한다.
// 기본 생성자의 인자를 property 로 정의해 사용하기 위해서는 var, val 을 사용한다.
// 추가 생성자는 class 내부에 선언한다.
// constructor 키워드 앞에 modifier를 붙여 객체 생성을 제한 할 수 있다.
// class Person private constructor()a
class Person constructor(name: String, var age: Int) {

    // 추가 생성자임 primary constructor가 있다면 " : this로 생성자를 호출 해야 한다."
    // secondary constructor에서는 파라미터에 val or var를 붙일 수 없다.
    // primary constructor -> initializer -> secondary constructor 순서
    constructor(name: String, age: Int, address: String) : this(name, age) {
        println("I'm secondary constructor")    
    }
    val lowerName = "My name is ${name.toLowerCase()}".also(::println)
    init {
        // initializer 는 코드 라인에 따라서 시퀀셜 하게 실행된다 따라서 아래의 upperName 이 초기화 되기 전, 위의 name이 초기화 된 후 실행 된다.
        // 따라서 여기 블록에서는 upperName 프로퍼티에는 접근할 수 없다.
        println("I'm initializer")
    }
    val upperName = "My name is ${name.toUpperCase()}".also(::println)

}

fun main(args: Array<String>) {
    // 객체 생성 할때에 new 키워드는 없어도 된다.
    val person: Person = Person("Wonhyung", 18)
    println("person = $person")
    println("person.lowerName = ${person.lowerName}")
    println("person.upperName = ${person.upperName}")
    println("person.age = ${person.age}")
    val person2: Person = Person("Wonhyung", 18, "address")
}