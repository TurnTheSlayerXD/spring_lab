plugins {
    id("java")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven {
        url = uri("https://mvnrepository.com")
    }
}

dependencies {
    implementation(project(":services"))
    implementation("org.springframework.boot:spring-boot:3.4.5")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.5")

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}



