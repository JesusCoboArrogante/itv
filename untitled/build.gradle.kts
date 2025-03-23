plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //Cache Caffeine
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.0")

    // koin
    implementation("io.insert-koi-core:4.0.2")
    implementation("io.insert-koin:koin-annotations:2.0.0")


    //base de datos
    implementation("com.h2database:h2:2.3.232")

    //libreria Test
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")

    //libreria de JDBI
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jdbi:jdbi3:-core:3.48.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.48.0")

    //libreria de json
    implementation("org.jetbrains.kotlin:kotlinx-serialization-json:1.8.0")

    //libreria log
    implementation("ch.qos.logback-classic:1.5.12")
    implementation("org.ligthousegames:logging:1.5.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

