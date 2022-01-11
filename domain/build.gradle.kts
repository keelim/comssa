plugins {
    id("library-setting-plugin")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(projects.data)
    implementation(AndroidX.core_ktx)

    implementation(Hilt.android)
    kapt(Hilt.hilt_compiler)

    implementation(Paging.common)

    implementation(SquareUp.timber)

    implementation(Kotlin.stdlibJvm)
    implementation(Kotlin.Coroutines.android)

    testImplementation(AppTest.junit)
    androidTestImplementation(AppTest.androidJunit)
    androidTestImplementation(AppTest.espressoCore)
    androidTestImplementation(Kotlin.Coroutines.test)
}
