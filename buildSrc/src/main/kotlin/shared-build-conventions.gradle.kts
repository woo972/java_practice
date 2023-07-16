plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.projectlombok:lombok:1.18.22")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    tasks.withType(Jar::class) {
        manifest {
            from("src/main/resources/META-INF/MANIFEST.MF")
        }
    }
}
