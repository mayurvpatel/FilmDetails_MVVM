// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        mavenGoogle()
    }
    dependencies {
        classpath(ClassPaths.androidGradle)
        classpath(ClassPaths.kotlinGradle)
        classpath(ClassPaths.hiltGradle)
        classpath(ClassPaths.navigationGradle)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}