# Overview

This project is a console-based weather fetcher application that retrieves real-time weather conditions for a user-specified city. It serves as a practical exercise in asynchronous networking, specifically focusing on handling background tasks and API requests to deliver formatted weather data directly to the command line.

[Software Demo Video](https://youtu.be/YNb-gN9itUE)

# Development Environment

The application is written entirely in Kotlin. It leverages Kotlin's modern syntax, null safety, and concise data classes to ensure reliable and readable data handling.

- **Kotlin Coroutines**: Used to manage asynchronous network requests, allowing the application to fetch data over the internet without blocking the main execution thread.

- **Development Environment**: Developed, compiled, and tested on macOS using a MacBook Pro.

- **OpenWeatherMap API**: Serves as the external REST API source for real-time temperature and weather conditions.

- **JSON Serialization**: Utilized to parse the raw JSON HTTP responses from the weather API into structured Kotlin objects.
# Useful Websites

* [Kotlin Docs](https://kotlinlang.org/docs/)
