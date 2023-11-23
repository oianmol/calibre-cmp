package dev.baseio.kalibre

expect val platform: String

class Greeting {
    fun greeting() = "Hello, $platform!"
}