package com.example.practice.basics

import java.util.Scanner


//array example 
fun main() {
    var array= arrayOf(5,44,6,99,11,1,-10,16)
    var minMaxVal= minMax(array)
    println(minMaxVal)

}

fun minMax(array: Array<Int>): Any {
    val scanner = Scanner(System.`in`)
    println("You want max Value")
    var a= scanner.nextInt()
    if (a!=0)
        return findMax(array)
    else
        return findMin(array)
}

fun findMin(array: Array<Int>): Int {
    var min=array[0]
    array.forEach {
        if (it<min)
            min=it
    }
    return min
}

fun findMax(array: Array<Int>): Int {
    var max=array[0]
    array.forEach {
        if (it>max)
            max=it
    }
    return max
}
