plugins {
    alias(libs.plugins.library.common)
    alias(libs.plugins.library.hilt)
    alias(libs.plugins.library.compose)
}

android {
    namespace = "com.xayah.feature.flavor.premium"
}

dependencies {
    // Core
    implementation(project(":core:provider"))
}