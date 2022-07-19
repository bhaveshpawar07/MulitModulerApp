plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}
android {
    buildFeatures {
        viewBinding = true
    }
}
dependencies {
    implementation(project(":core-model"))
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Material.material)

    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.recyclerView)

    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)

    implementation(Dependencies.Logging.timber)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}