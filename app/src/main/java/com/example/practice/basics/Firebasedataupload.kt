package com.example.practice.basics

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// Define your data model class
data class User222(val name: String, val email: String)

fun main() {
    // Initialize Firebase
    val firebaseDatabase = FirebaseDatabase.getInstance()
    val databaseReference: DatabaseReference = firebaseDatabase.reference

    // Create a new user object
    val user = User222("John Doe", "john@example.com")

    // Push the user object to the Firebase database
    val newUserReference = databaseReference.child("users").push()
    newUserReference.setValue(user)
        .addOnSuccessListener {
            println("User data saved successfully!")
        }
        .addOnFailureListener { e ->
            println("Failed to save user data: ${e.message}")
        }
}
