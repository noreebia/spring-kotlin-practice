import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.noreebia"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.postgresql:postgresql")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-common:2.2.0")


    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-data-rest
//    implementation("org.springdoc:springdoc-openapi-data-rest:1.7.0")
// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui
//    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-kotlin
//    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:1.7.0")

//    implementation("org.springdoc:springdoc-openapi-data-rest")
//    implementation("org.springdoc:springdoc-openapi-ui")
//    implementation("org.springdoc:springdoc-openapi-kotlin")

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
