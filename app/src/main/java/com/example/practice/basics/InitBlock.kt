package com.example.practice.basics

fun main() {
    val user=User("mAbdul","Moiz",21)
    user.lastName="cjc"
    println(user.lastName)
}
//primary constructor
class User(firstName:String, lastName:String="LastName",var age:Int=0){
    init {
        println("User $firstName created")
    }
    var firstName=firstName
        get() {
            return "First Name: $field "
        }
        set(value) {
            field = value
        }
    var lastName=lastName
        get() {
            return "First Name: $field "
        }
        set(value) {
            field = value
        }
}