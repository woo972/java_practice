plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register("testWithDoneMsg"){
    group = "verification" // gradle tasks group 설정
    description = "echo 'done' message after test has been done"
    dependsOn("test") // "test" task 수행 후에 이 task를 실행

    doLast {
        println("custom msg: done") // task 마지막에 실행
    }
}

// 작동 안됨
//tasks.register<Copy>("backupTestXml"){
//    from("build/test-results/test")
//    into("/tmp/")
//
//    exclude("binary/**")
//}