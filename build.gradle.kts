@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.library) apply false
    alias(libs.plugins.compose) apply false
    kotlin("android").version(libs.versions.org.jetbrains.kotlin.android).apply(false)
    kotlin("multiplatform").version(libs.versions.org.jetbrains.kotlin.android).apply(false)
    kotlin("jvm").version(libs.versions.org.jetbrains.kotlin.android).apply(false)
    kotlin("plugin.serialization").version(libs.versions.org.jetbrains.kotlin.android).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}