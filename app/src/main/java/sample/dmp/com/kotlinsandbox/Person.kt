package sample.dmp.com.kotlinsandbox

class Person() {
    var name: String? = null
    var age: Int? = null
    var male: Boolean? = false

    constructor(name:String, age:Int, male:Boolean): this() {
        this.name = name
        this.age = age
        this.male = male
    }
}