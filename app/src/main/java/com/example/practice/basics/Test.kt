package com.example.practice.basics

import java.util.Scanner

//
//class Car{
//    var name=""
//    var id=0
////    constructor(){
////
////    }
//    constructor(name:String,id:Int)  {
//        this.name=name
//        this.id=id
//    }
//}

fun main() {
//    var bmw=Car()

//    val day = 4
//
//    val result = when (day) {
//        1 -> "Monday"
//        2 -> "Tuesday"
//        3 -> "Wednesday"
//        4 -> "Thursday"
//        5 -> "Friday"
//        6 -> "Saturday"
//        7 -> "Sunday"
//        else -> "Invalid day."
//    }
//    println(result)
//
//    var name:String
//    name="cb"
//    val num=5
//    var b:Byte=5
//    val myNum1: Float = 35E3F
//    print(myNum1)
//    var b:Int=6
//    var f:Long=b.toLong()
//    var c:Char=b.toChar()
//    var s:String=b.toString()
//    println(s)
//    println(c)
//    var txt = "Please locate where 'locate' occurs!"
//    println(txt.indexOf("Please"))  // Outputs 7

//    var txt1 = "It's alright"
//    var txt2 = "That's great"
//    var txt3 = "That's \" vhvuv \"great"
//    println(txt3)

//    var firstName = "John "
//    var lastName = "Doe"
//    println(firstName.plus(lastName))

//    fun main() {
//        val time = 20
//        val greeting = if (time < 18) "Good day." else "Good evening."
//        println(greeting)
//    }

//    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
//    cars.forEach { new->
//        println(new)
//    }
//    for (car in cars){
//        println(car)
//    }
//    for (i in 0..cars.size-1){
//        println(cars[i])
//    }

//    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
//    cars[0] = "Opel"
//    println(cars[0])

//    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
//    if ("Volvo" in cars) {
//        println("It exists!")
//    } else {
//        println("It does not exist.")
//    }

//    print("Enter text: ")
//    var input = readLine()
//    print("You entered: $input")

//    var sc =Scanner(System.`in`)
//    var input2=sc.nextInt()
//    print(input2)

    var num1 = 0
    outer@ while (num1 < 5 ) {
        num1++
        var num2 = 0

        inner@ while (num2 < 5) {
            if (num2 == 2) break@outer
            println("num1 = $num1, num2 = $num2")
            num2++
        }
    }
}
