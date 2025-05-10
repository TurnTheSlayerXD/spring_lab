plugins {
    id("java")
    id("org.springframework.boot") version "3.3.0" apply false
    id("io.spring.dependency-management") version "1.1.5"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven {
        url = uri("https://mvnrepository.com")
    }
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    implementation("org.hibernate.orm:hibernate-core:6.6.13.Final")
    implementation("org.springframework.data:spring-data-jpa:3.4.5")
}

tasks.withType(JavaCompile::class).configureEach {
    options.compilerArgs.add("-parameters")
}


// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

