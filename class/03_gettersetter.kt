class MyClass (property1: Int){
    // var <propertyName>[: <PropertyType>] [= <property_initializer>]
    //     [<getter>]
    //     [<setter>]
    val property1: Int = property1
    // var property2: Int? // var property는 get으로 초기화 되지 않음.
    val property2: Int?
        get() = 15;

    var privateSetter: String = "abc"
        private set

    // backing fields
    var property3: String = "abc"
        get() = field
        set(value) {
            field = value
        } 

    // backing properties
    private var _property4: String = ""
    var property4: String
        get() = _property4
        set(value) {
            _property4 = value;
        }
}

fun main(args: Array<String>) {
    var myClass = MyClass(13)
    println("myClass.property1 = ${myClass.property1}")
    println("myClass.property2 = ${myClass.property2}")
    // privateSetter.privateSetter = "ABC" // private set으로 지정했기 때문에 수정할 수 없음.
    println("myClass.privateSetter = ${myClass.privateSetter}")
    println("myClass.property3 = ${myClass.property3}")
    myClass.property3 = "ABC"
    println("myClass.property3 = ${myClass.property3}")
    println("myClass.property4 = ${myClass.property4}")
    myClass.property4 = "ABC"
    println("myClass.property4 = ${myClass.property4}")
}