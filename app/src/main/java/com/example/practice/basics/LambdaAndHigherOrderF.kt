package com.example.practice.basics

// Example 1: Simple Lambda Expression
val square: (Int) -> Int = { x -> x * x }

// Example 2: Lambda with No Parameters
val greet: () -> Unit = { println("Hello, Kotlin Lambda!") }

// Example 3: Lambda as an Argument
fun executeOperation(operation: (Int, Int) -> Int) {
    val result = operation(10, 5)
    println("Result: $result")
}

// Example 4: Lambda with Receiver (Extension Function Style)
val sum: Int.(Int) -> Int = { other -> this + other }

fun main() {
    // Using Simple Lambda Expression
    val squareResult = square(5)
    println("Square of 5: $squareResult") // Output: Square of 5: 25

    // Using Lambda with No Parameters
    greet() // Output: Hello, Kotlin Lambda!

    // Using Lambda as an Argument
    executeOperation { a, b -> a + b } // Output: Result: 15
    executeOperation { a, b -> a * b } // Output: Result: 50

    // Using Lambda with Receiver (Extension Function Style)
    val result = 10.sum(5)
    println("Sum: $result") // Output: Sum: 15
}
