import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
plugins {
    id("application-setting-plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.google.firebase.crashlytics")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("compose-plugin")
}

android {
    defaultConfig {
        applicationId = ProjectConfigurations.applicationId
        versionCode = ProjectConfigurations.versionCode
        versionName = ProjectConfigurations.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val AD_OPEN_ID: String = gradleLocalProperties(rootDir).getProperty("AD_OPEN_ID")
    val APPLICATION_ID: String = gradleLocalProperties(rootDir).getProperty("APPLICATION_ID")
    val SPLASH_UNIT: String = gradleLocalProperties(rootDir).getProperty("SPLASH_UNIT")
    buildTypes {
        defaultConfig{
            buildConfigField("String", "AD_OPEN_ID", AD_OPEN_ID)
            buildConfigField("String", "SPLASH_UNIT", SPLASH_UNIT)
            manifestPlaceholders["APPLICATION_ID"] = APPLICATION_ID
        }
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.common)
    implementation(projects.compose)
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.fragment:fragment-ktx:1.4.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.lifecycle:lifecycle-process:2.3.1")
    implementation("com.google.android.play:core-ktx:1.8.1")

    implementation(platform("com.google.firebase:firebase-bom:28.1.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-perf-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("androidx.paging:paging-common-ktx:3.1.0")
    implementation("androidx.paging:paging-runtime-ktx:3.1.0")

    testImplementation(AppTest.junit)
    androidTestImplementation(AppTest.androidJunit)
    androidTestImplementation(AppTest.espressoCore)

    implementation(Kotlin.stdlibJvm)

    implementation("com.jakewharton.timber:timber:5.0.1")

    implementation("com.google.android.gms:play-services-ads:20.5.0")

    implementation(Hilt.android)
    kapt(Hilt.hilt_compiler)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2")

    implementation(Coil.coil)
    implementation(Coil.coilGif)

    implementation("com.google.android.gms:play-services-oss-licenses:17.0.0")
    implementation(AndroidX.startup)

    implementation(Dep.AndroidX.Compose.runtime)
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.materialAdapter)
    implementation(Dep.AndroidX.Compose.tooling)
    implementation(Dep.AndroidX.Compose.livedata)
    implementation(Dep.AndroidX.Compose.animation)
}
apply(from = "$rootDir/spotless.gradle")
