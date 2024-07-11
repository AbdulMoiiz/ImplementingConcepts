package com.example.practice.basics

fun main() {
    val configManager = ConfigurationManager.getInstance()

    val dbUrl = configManager.getConfig("db_url")
    val apiUrl = configManager.getConfig("api_url")
    val debugMode = configManager.getConfig("debug_mode")

    println("Database URL: $dbUrl")
    println("API URL: $apiUrl")
    println("Debug Mode: $debugMode")
}


class ConfigurationManager private constructor() {
    private val configMap: MutableMap<String, String> = mutableMapOf()

    init {
        // Load configuration settings from file, database, or any other source
        // For simplicity, we'll hardcode some settings here
        configMap["db_url"] = "jdbc:mysql://localhost:3306/mydatabase"
        configMap["api_url"] = "https://api.example.com"
        configMap["debug_mode"] = "false"
    }

    companion object {
        private var instance: ConfigurationManager? = null

        fun getInstance(): ConfigurationManager {
            if (instance == null) {
                instance = ConfigurationManager()
            }
            return instance!!
        }
    }

    fun getConfig(key: String): String? {
        return configMap[key]
    }
}
