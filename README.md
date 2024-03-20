# Ballast Navigation with KSP demo project

[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This is a demo project to showcase using Ballast navigation in a typesafe way using KSP. 
The app is a basic Kotlin Multiplatform app using a template generated from [KMM-Template](https://kmp.jetbrains.com/) for Android and iOS.
It includes shared business logic and data handling, and a shared UI implementation using Compose Multiplatform.

### Overview

Declare screens using a sealed interface/class
```kotlin
@Routes
sealed interface Screen{
    @InitialRoute
    data object ListScreen: Screen

    data class DetailScreen(val objectId: Int): Screen

    data class Settings(val count: Double): Screen
}
```
Build and have:
```kotlin
val coroutineScope = rememberCoroutineScope()
    val controller = rememberController(coroutineScope)

    Destination(
        controller,
        onNavigate = {
            when(it){
                is Screen.DetailScreen -> DetailScreen(it.objectId)
                is Screen.ListScreen -> ListScreen()
                is Screen.Settings -> TODO()
            }
        }
    )
```

### Technologies

The data displayed by the app is from [The Metropolitan Museum of Art Collection API](https://metmuseum.github.io/).

The app uses the following multiplatform dependencies in its implementation:

- [Compose Multiplatform](https://jb.gg/compose) for UI
- [Ktor](https://ktor.io/) for networking
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization) for JSON handling
- [Kamel](https://github.com/Kamel-Media/Kamel) for image loading
- [Koin](https://github.com/InsertKoinIO/koin) for dependency injection
- [Ballast Nav Ext](https://github.com/Dilivva/BallastNavigationExt) for navigation based on [Ballast](https://github.com/copper-leaf/ballast)

> This is experimental and not ready for production