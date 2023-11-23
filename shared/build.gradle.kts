plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    jvm()
    android()

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.touchlab.kermit)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)
                implementation(libs.sqldelight.coroutines)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.sqldelight.driver.jvm)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.driver.android)
            }
        }

        /* Main hierarchy */
        jvmMain.dependsOn(commonMain)
        androidMain.dependsOn(commonMain)

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmTest by getting
        val androidUnitTest by getting

        /* Test hierarchy */
        jvmTest.dependsOn(commonTest)
        androidUnitTest.dependsOn(commonTest)
    }
}

android {
    namespace = "dev.baseio.kalibre"
    compileSdk = 31
    defaultConfig {
        minSdk = 21
    }
}
