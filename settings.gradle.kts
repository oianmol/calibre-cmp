rootProject.name = "kalibre-cmp"
include(":shared")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform").version("1.8.10")
        kotlin("plugin.serialization").version("1.8.10")
        id("com.android.library").version("7.4.2")
        id("com.squareup.sqldelight").version("1.5.5")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            library("kotlinx-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            library("touchlab-kermit", "co.touchlab:kermit:1.2.2")
            library("kotlinx-serialization-json", "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            library("kotlinx-datetime", "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            library("sqldelight-driver-android", "com.squareup.sqldelight:android-driver:1.5.5")
            library("sqldelight-driver-jvm", "com.squareup.sqldelight:sqlite-driver:1.5.5")
            library("sqldelight-coroutines", "com.squareup.sqldelight:coroutines-extensions:1.5.5")
        }
    }
}
