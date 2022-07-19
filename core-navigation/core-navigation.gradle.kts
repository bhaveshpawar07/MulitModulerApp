plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}

dependencies {

    implementation(Dependencies.Kotlin.stdLib)

    implementation(Dependencies.Android.appCompat)

    implementation(Dependencies.Android.navigationUi)
    implementation(Dependencies.Android.navigationFragment)

    implementation(Dependencies.Koin.core)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}