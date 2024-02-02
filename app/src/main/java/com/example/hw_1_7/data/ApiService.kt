package com.example.hw_1_7.data

import com.example.hw_1_7.response.door.DoorModel
import com.example.hw_1_7.response.camera.CameraSecond
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    suspend fun getCameras():Response<List<CameraSecond.Data.Camera>>

    @GET("doors")
    suspend fun getDoors():Response<List<DoorModel.Data>>
}