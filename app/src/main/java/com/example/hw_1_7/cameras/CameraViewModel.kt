package com.example.hw_1_7.cameras

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_1_7.data.Repository
import com.example.hw_1_7.data.Resource
import com.example.hw_1_7.response.camera.CameraSecond
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    fun getCameras():LiveData<Resource<List<CameraSecond.Data.Camera>>> = repository.getCameras()
}