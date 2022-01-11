plugins {
    id("library-setting-plugin")
    id("compose-plugin")
}

dependencies {
    implementation(Dep.AndroidX.Compose.runtime)
    implementation(Dep.AndroidX.Compose.ui)
    implementation(Dep.AndroidX.Compose.material)
    implementation(Dep.AndroidX.Compose.material3)
    implementation(Dep.AndroidX.Compose.materialAdapter)
    implementation(Dep.AndroidX.Compose.tooling)
    implementation(Dep.AndroidX.Compose.livedata)
    implementation(Dep.AndroidX.Compose.animation)
    implementation(Dep.AndroidX.Compose.activity)
}
