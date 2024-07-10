package com.example.practice.basics

data class Transaction(val id: Int, val amount: Double, val type: String, val date: String)

fun main() {
    val transactions = listOf(
        Transaction(1, 100.0, "Expense", "2024-07-10"),
        Transaction(2, 250.0, "Income", "2024-07-11"),
        Transaction(3, 80.0, "Expense", "2024-07-12"),
        Transaction(4, 300.0, "Income", "2024-07-12"),
        Transaction(5, 150.0, "Expense", "2024-07-13")
    )

    // Higher-order function to filter transactions by type and amount
    fun filterTransactions(transactions: List<Transaction>, predicate: (Transaction) -> Boolean): List<Transaction> {
        return transactions.filter(predicate)
    }

    // Higher-order function to map transactions to different format
    fun mapTransactions(transactions: List<Transaction>, mapper: (Transaction) -> Any): List<Any> {
        return transactions.map(mapper)
    }

    // Example usage:
    // Filter expenses greater than 100
    val filteredExpenses = filterTransactions(transactions) { it.type == "Expense" && it.amount > 100 }

    // Map transactions to amounts only
    val transactionAmounts = mapTransactions(transactions) { it.amount }

    // Print results
    println("Filtered Transactions:")
    filteredExpenses.forEach { println("Transaction ${it.id}: ${it.amount}, ${it.date}") }

    println("\nTransaction Amounts:")
    transactionAmounts.forEach { println("Amount: $it") }

    // Calculate total amount of income transactions
    val totalIncome = transactions
        .filter { it.type == "Income" }
        .sumOf { it.amount }
    println("\nTotal Income: $totalIncome")
}
