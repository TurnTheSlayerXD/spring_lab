
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
    implementation("org.hibernate.orm:hibernate-core:6.6.13.Final")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
}



