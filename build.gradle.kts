plugins {
    kotlin("jvm") version "1.9.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.9.0")
}

application {
    mainClass.set("MainKt")
}
