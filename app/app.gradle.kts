plugins {
    id ("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}


android {
    compileSdk = 32
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.wednesday.mulitmodulerapp"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName =  "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }

    flavorDimensions += "version"
    productFlavors {
        create("qa") {
            dimension = "version"
            applicationIdSuffix = ".qa"
            versionNameSuffix = "-qa"
        }
        create("prod") {
            dimension = "version"
            applicationIdSuffix = ".prod"
            versionNameSuffix = "-prod"
        }
        create("dev") {
            dimension = "version"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "${project.rootDir}/tools/proguard-rules.pro"
            )
        }
        applicationVariants.all {
            val variant = this
            variant.outputs
                .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
                .forEach { output ->
                    val flavour = variant.flavorName
                    val builtType = variant.buildType.name
                    val versionName = variant.versionName
                    val vCode = variant.versionCode
                    output.outputFileName =
                        "app-${flavour}-${builtType}-${versionName}(${vCode}).apk".replace(
                            "-${flavour}",
                            ""
                        )
                }
        }
    }
}

dependencies {

    implementation(project(":core-database"))
    implementation(project(":core-network"))
    implementation(project(":core-presentation"))
    implementation(project(":core-repository"))
    implementation(project(":core-common"))
    implementation(project(":core-navigation"))
    implementation(project(":feature-search"))
    implementation(project(":feature-weather"))

    implementation(Dependencies.Kotlin.stdLib)

    implementation(Dependencies.Koin.core)
    implementation(Dependencies.Koin.android)

    implementation(Dependencies.Material.material)

    implementation(Dependencies.Logging.timber)

    implementation(Dependencies.Android.splashScreen)
    implementation(Dependencies.Android.navigationFragment)
    implementation(Dependencies.Android.navigationUi)

}