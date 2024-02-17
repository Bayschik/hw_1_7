package com.example.hw_1_7.domain.usecases

import androidx.lifecycle.LiveData
import com.example.hw_1_7.data.utils.Resource
import com.example.hw_1_7.domain.models.door.DoorModel
import com.example.hw_1_7.domain.repositories.DoorsRepository
import javax.inject.Inject

class GetDoorsUseCase @Inject constructor(
    private val doorsRepository: DoorsRepository
) {
    suspend fun getDoors() = doorsRepository.getDoors()
}