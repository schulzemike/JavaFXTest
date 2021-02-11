plugins {
  java
  application
  id("org.openjfx.javafxplugin") version ("0.0.9")
  id("org.beryx.jlink") version ("2.12.0")
}

repositories {
  mavenCentral()
}

tasks.named<Wrapper>("wrapper") {
//  downgrade zu version 6.5.1 da javafx plugin mit 6.6 nicht kompatibel ist -
//  @see https://github.com/openjfx/javafx-gradle-plugin/issues/89
  gradleVersion = "6.5.1"
}

java{
  sourceCompatibility = JavaVersion.VERSION_15
  targetCompatibility = JavaVersion.VERSION_15
}

javafx {
  version = "15.0.1"
  modules("javafx.controls", "javafx.fxml")
}

application {
  mainClassName = "my.project.MyFxApplication"
}



jlink {
  addOptions("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages")
  launcher {
    name = "MyFxApplication"
  }
}
