plugins {
    id("java")
    id("shared-build-conventions")
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.projectreactor:reactor-core:3.5.5")
    implementation("io.projectreactor:reactor-test:3.5.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.projectlombok:lombok:1.18.22")
}
