plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}

android {
    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {

    implementation(project(":core-navigation"))
    implementation(project(":core-common"))

    implementation(Dependencies.Kotlin.stdLib)

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.navigation)
    implementation(Dependencies.Koin.compose)

    implementation(Dependencies.Material.material)

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.animation)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.viewModel)
    implementation(Dependencies.Compose.materialIconCore)
    implementation(Dependencies.Compose.materialIconExtended)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.liveData)

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