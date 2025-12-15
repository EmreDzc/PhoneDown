plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.phonedown"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.phonedown"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Firebase BoM (Bill of Materials) - Sürümleri otomatik yönetir
    implementation(platform("com.google.firebase:firebase-bom:34.7.0"))

    // Firebase Realtime Database
    implementation("com.google.firebase:firebase-database")

    // Firebase Analytics (Zorunlu değil ama önerilir)
    implementation("com.google.firebase:firebase-analytics")
}