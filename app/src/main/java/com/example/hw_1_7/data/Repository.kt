package com.example.hw_1_7.data

import androidx.lifecycle.LiveData
import com.example.hw_1_7.base.BaseRepository
import com.example.hw_1_7.response.camera.CameraSecond
import com.example.hw_1_7.response.door.DoorModel
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService): BaseRepository(apiService) {
    fun getCameras():LiveData<Resource<List<CameraSecond.Data.Camera>>> = performRequest{
        apiService.getCameras().body()!!
    }

    fun getDoors():LiveData<Resource<List<DoorModel.Data>>> = performRequest{
        apiService.getDoors().body()!!
    }
}