package com.example.practice.basics

fun main() {
    var person=Person()
    println()
}
//secondary constructor
class Person(private var name:String,var lastName:String,var age:Int){
    constructor(name:String): this(name,"",0)
    constructor(name:String,age:Int): this(name,"",age)
    constructor():this("","",0)
}