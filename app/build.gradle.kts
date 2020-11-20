import me.moallemi.gradle.advancedbuildversion.gradleextensions.FileOutputConfig
import me.moallemi.gradle.advancedbuildversion.gradleextensions.VersionCodeConfig
import me.moallemi.gradle.advancedbuildversion.gradleextensions.VersionCodeType
import me.moallemi.gradle.advancedbuildversion.gradleextensions.VersionNameConfig

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("me.moallemi.advanced-build-version")
//    id("androidx.navigation.safeargs.kotlin")
}

advancedVersioning {

    nameOptions(closureOf<VersionNameConfig> {
        versionMajor(0)
        versionMinor(0)
        versionPatch(0)
        versionBuild(versionCode)
    })

    codeOptions(closureOf<VersionCodeConfig> {
        versionCodeType(VersionCodeType.AUTO_INCREMENT_ONE_STEP)
        dependsOnTasks("release")
    })

    outputOptions(closureOf<FileOutputConfig> {
        renameOutput(true)
        nameFormat("\$projectName-\$buildType-\$versionName")
    })

}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        applicationId = Versions.applicationId
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdk)
        versionCode = advancedVersioning.versionCode
        versionName = advancedVersioning.versionName

        buildConfigField("String", "API_KEY", "${properties["API_KEY"]}")
        testInstrumentationRunner = Dependencies.androidJunitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }

    kotlinOptions {
        jvmTarget = Versions.javaVersion.toString()
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(fileTree(Dependencies.fileTree))
    implementation(Dependencies.stdlibKotlin)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.coordinatorLayout)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testExt)
    androidTestImplementation(Dependencies.espresso)


    //coroutines
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)

    //ui
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    //navigation
    implementation(Dependencies.navigationFragmentKtx)
    implementation(Dependencies.navigationUiKtx)


    //network
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.okHttp)

    //arch components
    implementation(Dependencies.lifecycleExt)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.liveDataKtx)
    implementation(Dependencies.viewModelSavedState)
    implementation(Dependencies.lifecycleCommonJava8)
    implementation(Dependencies.lifecycleProcess)
    //Room
    implementation(Dependencies.room)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)

    //logging
    implementation(Dependencies.timber)

    implementation(Dependencies.picasso)

}
