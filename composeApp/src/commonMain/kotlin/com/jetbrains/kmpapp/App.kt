package com.jetbrains.kmpapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.dilivva.ballastnavigationext.Destination
import com.dilivva.ballastnavigationext.annotation.InitialRoute
import com.dilivva.ballastnavigationext.annotation.Routes
import com.jetbrains.kmpapp.screens.detail.DetailScreen
import com.jetbrains.kmpapp.screens.list.ListScreen

@Routes
sealed interface Screen{
    @InitialRoute
    data object ListScreen: Screen

    data class DetailScreen(val objectId: Int): Screen

    data class Settings(val count: Double): Screen
}

@Composable
fun App() {
    MaterialTheme {
        MainNavigation()
    }
}


@Composable
fun MainNavigation(){
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


}