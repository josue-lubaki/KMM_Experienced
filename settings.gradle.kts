pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
//        val kotlinVersion = extra["kotlin.version"] as String
//        val agpVersion = extra["agp.version"] as String
//        val composeVersion = extra["compose.version"] as String

//        kotlin("jvm").version(kotlinVersion)
//        kotlin("multiplatform").version(kotlinVersion)
//        kotlin("android").version(kotlinVersion)

//        id("com.android.application").version(agpVersion)
//        id("com.android.library").version(agpVersion)

//        id("org.jetbrains.compose").version(composeVersion)
//        kotlin("plugin.serialization").version(kotlinVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KMMExperiments"
include(":androidApp")
include(":shared")