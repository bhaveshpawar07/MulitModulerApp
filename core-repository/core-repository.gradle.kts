plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${rootProject.projectDir}/android.gradle")
}

dependencies {

    implementation(project(":core-model"))
    implementation(project(":core-network"))
    implementation(project(":core-database"))
    implementation(project(":core-common"))

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.Kotlin.serialization)

    implementation(Dependencies.Logging.timber)

    implementation(Dependencies.Coroutines.core)

    implementation(Dependencies.Koin.core)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}