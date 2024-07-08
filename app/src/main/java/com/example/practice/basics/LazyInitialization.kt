package com.example.practice.basics

fun main() {
    var user1 = User("Muhammad", "Ahmad")
    val user2 by lazy {
        User("Ali", "Ahmad")
    }
    println(user1.firstName)
    println(user1.lastName)
    println(user2.firstName)
    println(user2.lastName)
}


