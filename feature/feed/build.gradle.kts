plugins {
    id("library-setting-plugin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android{
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(projects.common)
    implementation(projects.data)
    implementation(AndroidX.core_ktx)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.material)
    implementation(AndroidX.activity_ktx)
    implementation(AndroidX.fragment_ktx)
    implementation(AndroidX.navigation_fragment)
    implementation(AndroidX.navigation_ui)

    implementation(SquareUp.retrofit)
    implementation(SquareUp.retrofit_gson)

    implementation(Glide.core)
    kapt(Glide.compiler)

    implementation(Hilt.android)
    kapt(Hilt.hilt_compiler)

    testImplementation(AppTest.junit)
    androidTestImplementation(AppTest.androidJunit)
    androidTestImplementation(AppTest.espressoCore)
}
