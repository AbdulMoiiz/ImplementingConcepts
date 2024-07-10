package com.example.practice.basics

// Interface defining some functionality
interface Printer {
    fun print(message: String)
}

// Class that implements the Printer interface
class BasicPrinter : Printer {
    override fun print(message: String) {
        println("Printing: $message")
    }
}

// Class that delegates Printer interface implementation to another object
class BetterPrinter(printer: Printer) : Printer by printer {
    // Additional functionality can be added here
    fun printTwice(message: String) {
        print(message)
        print(message)
    }
}

fun main() {
    // Creating instances of BasicPrinter and BetterPrinter
    val basicPrinter = BasicPrinter()
    val betterPrinter = BetterPrinter(basicPrinter)

    // Using BasicPrinter directly
    basicPrinter.print("Hello, BasicPrinter!")

    // Using BetterPrinter, which delegates print functionality to BasicPrinter
    betterPrinter.print("Hello, BetterPrinter!")
    betterPrinter.printTwice("Hello, BetterPrinter Twice!")
}
