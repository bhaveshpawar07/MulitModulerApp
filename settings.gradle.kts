pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MulitModulerApp"
include (":app")
include(":core-database")
include(":core-network")
include(":core-repository")
include(":core-presentation")
include(":feature-weather")
include(":feature-search")
include(":core-common")
include(":core-model")
include(":core-navigation")
include(":core-test")

for (project in rootProject.children) {
    project.buildFileName = project.name + ".gradle.kts"
}