plugins {
    kotlin("jvm") version "1.5.30"
    id("org.jetbrains.intellij") version "1.1.6"
    java
}

group = "net.allape"
version = "0.10.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("com.google.code.gson:gson:2.8.8")

    compileOnly(files("/Applications/IntelliJ IDEA.app/Contents/plugins/remote-run/lib/remote-run.jar"))
    compileOnly(files("/Applications/IntelliJ IDEA.app/Contents/plugins/terminal/lib/terminal.jar"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("IU-2021.1")
    updateSinceUntilBuild.set(false)
}
tasks {
    patchPluginXml {
        sinceBuild.set("211.000")
    }
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}