import java.net.URL
import java.net.URLEncoder
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val apiKey = "d562222067538f353d1f84912fe03a62"

    println("🌤️ Welcome to the Kotlin Weather Fetcher!")

    while (true) {
        print("\nEnter a city name (or type 'exit' to quit): ")
        val input = readlnOrNull()?.trim()

        if (input.isNullOrEmpty()) {
            println("City name cannot be empty. Please try again.")
            continue
        }

        if (input.lowercase() == "exit") {
            println("Goodbye!")
            break
        }

        try {
            val encodedCity = URLEncoder.encode(input, "UTF-8")
            val url = "https://api.openweathermap.org/data/2.5/weather?q=$encodedCity&appid=$apiKey&units=metric"
            val response = URL(url).readText()

            // 1. Find the temperature using Regex
            val tempRegex = """"temp":([\d.-]+)""".toRegex()
            val tempMatch = tempRegex.find(response)
            val temp = tempMatch?.groupValues?.get(1) ?: "Unknown"

            // 2. Find the weather description using Regex
            val descRegex = """"description":"([^"]+)"""".toRegex()
            val descMatch = descRegex.find(response)
            val description = descMatch?.groupValues?.get(1)?.replaceFirstChar { it.uppercase() } ?: "Unknown"

            // 3. Print the clean output
            println("\n🌍 Weather in $input:")
            println("🌡️ Temperature: $temp°C")
            println("☁️ Conditions: $description")

        } catch (e: Exception) {
            // Handle common errors cleanly
            if (e.message?.contains("404") == true) {
                println("❌ City not found. Please check the spelling and try again.")
            } else {
                println("❌ Error fetching data: ${e.message}")
            }
        }
    }
}