plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.safe.args.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.junemon.wastetreatment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.junemon.wastetreatment"
        minSdk = 24
        targetSdk = 34
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

    kapt {
        correctErrorTypes = true
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    androidTestImplementation (libs.mockk.android)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    implementation (libs.androidx.espresso.idling.resource)
    //konsist
    testImplementation(libs.konsist)
    //splash
    implementation(libs.splash.screen)
    //camerax
    implementation(libs.bundles.camerax.bundle)
    //gson
    implementation(libs.moshi)
    //coil
    implementation(libs.coil.view)
    //navigation
    implementation(libs.bundles.navigation.view)
    //room
    implementation(libs.bundles.room.bundle)
    ksp(libs.room.kapt)
    //internet & logging
    implementation(libs.bundles.okhttp.bundle)
    implementation(libs.bundles.retrofit.bundle)
    //epoxy
    implementation(libs.epoxy)
    ksp(libs.epoxy.kapt)
    //shimmer
    implementation(libs.shimmer.view)
    //coroutine
    implementation(libs.bundles.coroutine.bundle)
    testImplementation(libs.coroutine.unit.test)
    testImplementation(libs.turbine)
    //hilt
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)

    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.48")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.48")

    //timber
    implementation(libs.timber)
    //lottie
    implementation(libs.lottie.view)
    //zxing
    implementation(libs.core)
    //encrypted
    implementation(libs.androidx.security.crypto)

}