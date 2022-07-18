plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}

android {
    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {

    implementation(project(":core-navigation"))
    implementation(project(":core-common"))

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.Kotlin.gradlePlugin)

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.navigation)
    implementation(Dependencies.Koin.compose)

    implementation(Dependencies.Material.material)



    implementation(Dependencies.Image.coil)

    implementation(Dependencies.Logging.timber)
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.fragment)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.recyclerView)
    implementation(Dependencies.Android.lifecycleLiveDataCore)
    implementation(Dependencies.Android.lifecycleLiveDataKtx)
    implementation(Dependencies.Android.lifecycleViewModel)
    implementation(Dependencies.Android.lifecycleViewModelKtx)
    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)
    implementation(Dependencies.Android.splashScreen)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}