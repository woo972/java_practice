plugins {
    application
    id("shared-build-conventions")
}

dependencies {
    implementation("javassist:javassist:3.1")
}


java {
    tasks.withType(Jar::class) {
        manifest {
            from("src/main/resources/META-INF/MANIFEST.MF")
        }
    }
}