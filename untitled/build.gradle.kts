plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/kotlinx-serialization-json/1.8.0/kotlinx-serialization-json-1.8.0.pom")
    }
}


dependencies {
    // Base de datos a usar, driver
    implementation("com.h2database:h2:2.3.232")

    // JDBI
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jdbi:jdbi3-core:3.48.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.48.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

    // Logger
    implementation("org.lighthousegames:logging:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")

    // Cache Caffeine
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.0")

    // Resuly: ROP
    implementation("com.michael-bull.kotlin-result:kotlin-result:2.0.1")


    // Test
    testImplementation("io.mockk:mockk:1.13.16") // Mocks
    testImplementation(kotlin("test")) // Test JUnit
    testImplementation("org.jdbi:jdbi3-testing:3.48.0") // Testing JDBI
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

