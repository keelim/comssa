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

    implementation(AndroidX.core_ktx)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.material)
    implementation(AndroidX.activity_ktx)
    implementation(AndroidX.fragment_ktx)
    implementation(AndroidX.navigation_fragment)
    implementation(AndroidX.navigation_ui)
    implementation(AndroidX.startup)

    implementation(Play.oss)
    implementation(Play.core)
    implementation(Play.admob)

    implementation(platform(Firebase.platform))
    implementation(Firebase.analytics)
    implementation(Firebase.auth)
    implementation(Firebase.crashlytics)
    implementation(Firebase.perf)
    implementation(Firebase.firestore)

    implementation(Paging.common)
    implementation(Paging.runtime)

    implementation(Dep.timber)

    implementation(Hilt.android)
    kapt(Hilt.hilt_compiler)

    implementation(Kotlin.stdlibJvm)
    implementation(Kotlin.Coroutines.android)
    implementation(Kotlin.Coroutines.play)

    implementation(Coil.coil)
    implementation(Coil.coilGif)

    implementation(Dep.AndroidX.Compose.runtime)
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.material3)
    implementation(Dep.AndroidX.Compose.materialAdapter)
    implementation(Dep.AndroidX.Compose.tooling)
    implementation(Dep.AndroidX.Compose.livedata)
    implementation(Dep.AndroidX.Compose.animation)
    testImplementation(AppTest.junit)
    androidTestImplementation(AppTest.androidJunit)
    androidTestImplementation(AppTest.espressoCore)
}
apply(from = "$rootDir/spotless.gradle")
