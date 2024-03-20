package com.jetbrains.kmpapp.screens.list

import com.jetbrains.kmpapp.data.MuseumObject
import com.jetbrains.kmpapp.data.MuseumRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListScreenModel(private val museumRepository: MuseumRepository)  {
    private val scope = CoroutineScope(SupervisorJob())
    val objects: StateFlow<List<MuseumObject>> = museumRepository.getObjects()



    fun getMuseums() = scope.launch {
        museumRepository.refresh()
    }
}
