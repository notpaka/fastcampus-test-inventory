plugins {
    java
    `java-test-fixtures`
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    
    testImplementation(platform("org.mockito:mockito-bom:5.8.0"))
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }
    
    jvmArgs = listOf("-Xmx2g")
}
