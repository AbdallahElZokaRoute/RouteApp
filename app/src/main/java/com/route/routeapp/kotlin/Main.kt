package com.route.routeapp.kotlin


fun main() {
    val person = Person("Ahmed", "Mohamed", "Kareem")
    //print(person.fullName)
    val rect: Rectangle = Rectangle(10, 5)
    print("Area = ${rect.area}")

}

//Kotlin , Swift , Javascript -> private , public getter and Setters

open class Shape(val width: Int, val height: Int)

class Rectangle(width: Int, height: Int) : Shape(width, height) {
    val area: Int
        get() {
            print("Calculating Area Now .......\n")
            return this.width * this.height
        }

}

class Person(var firstName: String, var middleName: String, var lastName: String) {


    private var fullName: String? = null
        get() = "$firstName $middleName $lastName"
        set(value2) {
            field = "first name = $firstName , $value2"
            print(field)
        }
    val greetFullName: String
        get() = "Hello , $fullName"
}
