plugins {
    id("java")
    id("shared-build-conventions")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}
