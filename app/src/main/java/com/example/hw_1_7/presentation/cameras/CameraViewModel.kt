package com.example.hw_1_7.presentation.cameras

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_1_7.data.Resource
import com.example.hw_1_7.domain.models.camera.CameraModel
import com.example.hw_1_7.domain.usecases.GetCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val getCamerasUseCase: GetCamerasUseCase):ViewModel() {
    fun getCameras():LiveData<Resource<CameraModel>> = getCamerasUseCase.getCameras()
}