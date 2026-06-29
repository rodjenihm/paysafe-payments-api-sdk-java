// All Rights Reserved, Copyright © Paysafe Holdings UK Limited 2025. For more information see LICENSE

plugins {
    `java-library`
    id("jacoco")
}

val applicationJavaVersion = 11
val jacocoVersion = "0.8.15"
val jacksonVersion = "2.22.0"
val junitVersion = "5.14.4"
val jknackVersion = "4.5.2"
val wiremockVersion = "3.13.2"
val slf4jVersion = "2.0.17"
val apacheHttpClientVersion = "5.6.1"
val jsonSmartVersion = "2.6.0"
val eclipseJettyHttpVersion = "11.0.26"
val commonsIoVersion = "2.22.0"
val mockitoVersion = "5.23.0"
val logbackClassicVersion = "1.5.35"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(applicationJavaVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // main
    implementation("org.apache.httpcomponents.client5:httpclient5:$apacheHttpClientVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion") {
        exclude("com.github.jknack:handlebars:4.3.1")
    }
    implementation("com.github.jknack:handlebars:$jknackVersion")

    // test
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion") {
        exclude("net.minidev:json-smart:2.5.0")
    }
    testImplementation("net.minidev:json-smart:$jsonSmartVersion")
    testImplementation("org.wiremock:wiremock:$wiremockVersion") {
        exclude("org.eclipse.jetty:jetty-http:11.0.24")
        exclude("commons-io:commons-io:2.11.0")
    }
    testImplementation("org.eclipse.jetty:jetty-http:$eclipseJettyHttpVersion")
    testImplementation("commons-io:commons-io:$commonsIoVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("ch.qos.logback:logback-classic:$logbackClassicVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
    jacoco {
        enabled = true
    }
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}