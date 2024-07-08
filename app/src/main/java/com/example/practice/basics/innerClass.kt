package com.example.practice.basics

class Bank {
    private val accounts = mutableListOf<Account>()

    inner class Account(val accountNumber: String, initialBalance: Double) {
        private var balance = initialBalance
        private val transactions = mutableListOf<Transaction>()

        fun deposit(amount: Double) {
            balance += amount
            transactions.add(Transaction("Deposit", amount))
        }

        fun withdraw(amount: Double) {
            if (balance >= amount) {
                balance -= amount
                transactions.add(Transaction("Withdrawal", amount))
            } else {
                println("Insufficient funds")
            }
        }

        fun getBalance(): Double {
            return balance
        }

        fun printTransactions() {
            println("Transactions for account $accountNumber:")
            for (transaction in transactions) {
                println("- ${transaction.type}: ${transaction.amount}")
            }
        }

        inner class Transaction(val type: String, val amount: Double)
    }

    fun openAccount(accountNumber: String, initialBalance: Double) {
        accounts.add(Account(accountNumber, initialBalance))
    }

    fun getAccount(accountNumber: String): Account? {
        return accounts.find { it.accountNumber == accountNumber }
    }
}

fun main() {
    val bank = Bank()
    bank.openAccount("123456789", 1000.0)
    val account = bank.getAccount("123456789")
    account?.deposit(500.0)
    account?.withdraw(200.0)
    account?.printTransactions()
}
