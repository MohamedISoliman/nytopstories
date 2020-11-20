object Dependencies {

    object Kotlin {


    }

    val fileTree = mapOf("dir" to "libs", "include" to listOf("*.jar"))
    const val stdlibKotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coordinatorLayout =
        "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorLayout}"


    //test
    const val androidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val junit = "junit:junit:${Versions.junit}"
    const val testExt = ("androidx.test.ext:junit:${Versions.testExt}")
    const val espresso = ("androidx.test.espresso:espresso-core:${Versions.testExt}")


    //coroutines + rx
    const val coroutinesCore = ("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}")
    const val coroutinesAndroid = ("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}")

    //ui
    const val recyclerView = ("androidx.recyclerview:recyclerview:${Versions.recyclerView}")
    const val material = ("com.google.android.material:material:${Versions.material}")

    //navigation
    const val navigationFragmentKtx =
        ("androidx.navigation:navigation-fragment-ktx:${Versions.navigationKtx}")
    const val navigationUiKtx = ("androidx.navigation:navigation-ui-ktx:${Versions.navigationKtx}")


    //network
    const val retrofit = ("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    const val moshi = ("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
    const val loggingInterceptor = ("com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}")
    const val okHttp = ("com.squareup.okhttp3:okhttp:${Versions.okHttp}")

    //arch components
    const val lifecycleExt =
        ("androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}")
    const val viewModelKtx =
        ("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}")
    const val liveDataKtx =
        ("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}")
    const val viewModelSavedState =
        ("androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}")
    const val lifecycleCommonJava8 =
        ("androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}")
    const val lifecycleProcess =
        ("androidx.lifecycle:lifecycle-process:${Versions.lifecycleVersion}")

    //Room
    const val room = ("androidx.room:room-runtime:${Versions.roomVersion}")
    const val roomCompiler = ("androidx.room:room-compiler:${Versions.roomVersion}")
    const val roomKtx = ("androidx.room:room-ktx:${Versions.roomVersion}")

    //logging
    const val timber = ("com.jakewharton.timber:timber:${Versions.timber}")

    const val picasso = ("com.squareup.picasso:picasso:${Versions.picasso}")


}