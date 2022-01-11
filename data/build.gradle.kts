import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
plugins {
    id("library-setting-plugin")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments.plus(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas",
                        "room.incremental" to "true",
                        "room.expandProjection" to "true"
                    )
                )
            }
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val BASE_URL: String = gradleLocalProperties(rootDir).getProperty("BASE_URL")
    val VERSION: String = gradleLocalProperties(rootDir).getProperty("VERSION")
    buildTypes {
        defaultConfig {
            buildConfigField("String", "BASE_URL", BASE_URL)
            buildConfigField("String", "VERSION", VERSION)
        }
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
}

dependencies {
    implementation(platform(Firebase.platform))
    implementation(Firebase.storage)
    implementation(Firebase.database)
    implementation(Firebase.firestore)

    implementation(AndroidX.core_ktx)

    implementation(Paging.common)
    implementation(Hilt.android)
    kapt(Hilt.hilt_compiler)

    implementation(Room.runtime)
    implementation(Room.ktx)
    ksp(Room.compiler)

    implementation(SquareUp.timber)
    implementation(Kotlin.stdlibJvm)
    implementation(Kotlin.Coroutines.android)
    implementation(Kotlin.Coroutines.play)

    implementation(SquareUp.core)
    implementation(SquareUp.loggingInterceptor)
    implementation(SquareUp.urlconnection)
    implementation(SquareUp.retrofit)
    implementation(SquareUp.retrofit_gson)
    implementation(SquareUp.retrofit_moshi)
    implementation(Dep.moshi_kotlin)
    ksp(Dep.moshi_codegen)

    testImplementation(AppTest.junit)
    androidTestImplementation(Room.testing)
    androidTestImplementation(AppTest.androidJunit)
    androidTestImplementation(AppTest.espressoCore)
    androidTestImplementation(Kotlin.Coroutines.test)
}
