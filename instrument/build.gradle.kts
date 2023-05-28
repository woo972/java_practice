plugins {
    application
    id("shared-build-conventions")
}

dependencies {
    implementation("javassist:javassist:3.1")
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11

    tasks.withType(Jar::class) {
        manifest {
            from("src/main/resources/META-INF/MANIFEST.MF")
        }
    }
}