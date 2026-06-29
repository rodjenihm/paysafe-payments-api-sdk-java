// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2026. For more information see LICENSE

plugins {
    id("java")
    id("org.springframework.boot") version "3.5.14"
    application
}

group = "com.paysafe.paymentsapi"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.paysafe.paymentsapi:sdk-java:latest.release")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.5.14")
    implementation("org.springframework.boot:spring-boot-starter-web:3.5.14")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.4.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.5.14")
    developmentOnly("org.springframework.boot:spring-boot-devtools:3.5.14")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClass.set("com.paysafe.payments.merchantdemo.DemoApplication")
}