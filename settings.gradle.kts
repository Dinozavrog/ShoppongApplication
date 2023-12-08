pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidLab2023"
include(":app")
include(":core")
include(":navigation")
include(":feature_login")
include(":feature_toasts")
include(":core_database")
include(":core_preference")
include(":feature_products")
include(":feature_basket")
include(":feature_profile")
include(":core_compose")
