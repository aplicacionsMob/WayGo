plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.waygo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.localpreferences"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    // Jetpack Compose
    implementation ("androidx.compose.ui:ui:1.6.0")
    implementation ("androidx.compose.material3:1.2.0")

    // Navigation per Jetpack Compose
    implementation ("androidx.navigation:navigation-compose:2.8.9")

    // Hilt per la injecció de dependències
    implementation ("com.google.dagger:hilt-android:2.51.1")
    implementation(libs.androidx.material3.android)
    kapt ("com.google.dagger:hilt-android-compiler:2.51.1")

    // Per recordar l'estat de la navegació
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}