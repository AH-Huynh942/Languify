import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("com.google.gms.google-services")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(projects.shared)
        }
    }
}

android {
    namespace = "languify.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "languify.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        manifestPlaceholders["pdftronLicenseKey"] = ""
        android.buildFeatures.buildConfig = true
        buildConfigField("String", "DETECTLANGUAGE_API_KEY", "\"5537f206c669c3b12239c879c820a454\"")

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.media3.common.ktx)
    debugImplementation(compose.uiTooling)
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // PDFTron dependencies
    implementation("com.pdftron:pdftron:11.0.0")
    implementation("com.pdftron:tools:11.0.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation(libs.detectlanguage)

    implementation(platform("com.google.firebase:firebase-bom:33.12.0"))
    implementation("com.google.firebase:firebase-analytics")



    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.mlkit:text-recognition:16.0.0")

    implementation("com.google.android.gms:play-services-measurement-api:22.4.0")
    implementation("com.google.android.gms:play-services-measurement-sdk-api:22.4.0")
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://pdftron-maven.s3.amazonaws.com/release") }
}