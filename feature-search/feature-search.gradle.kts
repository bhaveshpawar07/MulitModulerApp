plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}

dependencies {
    implementation(project(":core-presentation"))
    implementation(project(":core-repository"))
    implementation(project(":core-network"))
    implementation(project(":core-common"))
    implementation(project(":core-model"))
    implementation(project(":core-navigation"))
    implementation(project(":feature-weather"))

    implementation(Dependencies.Kotlin.stdLib)

    implementation(Dependencies.Coroutines.core)

    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.recyclerView)
    implementation(Dependencies.Material.material)

    implementation(Dependencies.Android.lifecycleViewModel)
    implementation(Dependencies.Android.lifecycleViewModelKtx)

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.navigation)
    implementation(Dependencies.Koin.compose)

    implementation(Dependencies.Logging.timber)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}