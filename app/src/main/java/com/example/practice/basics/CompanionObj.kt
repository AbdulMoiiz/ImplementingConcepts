package com.example.practice.basics

fun main() {
    MyClass.increment()
    var c=MyClass()
    c.incrementCount()
    println(MyClass.count)
}

class MyClass {
    var name:String="bchbc"
    companion object {
        var count: Int = 0

        fun resetCount() {
            count = 0
        }
        fun increment(){
            count++
        }
    }


}

fun MyClass.incrementCount() {
    println(name)
}


