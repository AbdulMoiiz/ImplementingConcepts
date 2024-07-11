package com.example.practice.basics

fun main() {
    println(Season.AUTUMN)

    val red = Color.RED
    println("Red color RGB: ${red.rgb}")
    println("Red color HEX code: ${red.getHexCode()}")


    //printing type of variable
    val x = 10
    val y = "Hello"
    val z = listOf(1, 2, 3)

    println("Type of x: ${x::class}")
    println("Type of y: ${y::class}")
    println("Type of z: ${z::class}")

}

enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun getHexCode(): String {
        return "#${Integer.toHexString(rgb)}"
    }
}