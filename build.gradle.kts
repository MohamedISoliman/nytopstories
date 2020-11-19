// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        val navVersion = "2.3.0-alpha03"
        classpath("org.ajoberstar:grgit:1.5.0")
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("me.moallemi.gradle:advanced-build-version:1.7.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks {
    delete(rootProject.buildDir)
}
