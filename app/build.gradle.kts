plugins {
    application
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://mvnrepository.com")
    }
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.17")

    testImplementation(libs.junit)

    implementation(libs.guava)

    implementation(project(":controllers"))


    implementation("org.postgresql:postgresql:42.7.5")
    implementation("org.hibernate.orm:hibernate-core:6.6.13.Final")

    implementation("org.springframework.boot:spring-boot-starter-web:3.4.5")
    implementation("org.springframework.boot:spring-boot-starter-jdbc:3.4.5")

    implementation("org.springframework.boot:spring-boot:3.4.5")


    implementation("org.hibernate.orm:hibernate-core:6.6.13.Final")

    implementation("org.springframework.boot:spring-boot-devtools:3.4.5")

    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")

    implementation("org.springframework.data:spring-data-jpa:3.4.5")

    implementation("org.springframework.boot:spring-boot-autoconfigure:3.4.5")


}


// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}


application {
    mainClass = "org.example.App"
}

