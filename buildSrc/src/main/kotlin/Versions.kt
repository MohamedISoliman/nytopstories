import org.gradle.api.JavaVersion

object Versions {

    //app
    const val applicationId = "io.github.mohamedisoliman.nytopstories"
    const val compileSdk = 29
    const val targetSdk = 29
    const val minSdkVersion = 21


    //Kotlin
    const val kotlinVersion = "1.4.0"
    const val coroutinesCore = "1.3.4"
    const val coroutinesAndroid = "1.3.4"
    val javaVersion = JavaVersion.VERSION_1_8

    //test
    const val junit = "4.13"
    const val testExt = "1.1.1"
    const val espresso = "3.2.0"


    //Android
    const val appcompat = "1.1.0"
    const val coreKtx = "1.3.0"
    const val constraintLayout = "2.0.0-beta7"
    const val coordinatorLayout = "1.1.0"
    const val recyclerView = "1.1.0"
    const val material = "1.1.0"
    const val navigationKtx = "2.3.0"
    const val lifecycleVersion = "2.2.0"

    //DB
    const val roomVersion = "2.2.4"


    //network
    const val retrofit = "2.7.2"
    const val okHttp = "4.4.0"

    //logging
    const val timber = "4.7.1"
    const val picasso = "2.71828"

}