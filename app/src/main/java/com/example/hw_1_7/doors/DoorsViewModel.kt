package com.example.hw_1_7.doors

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_1_7.data.Repository
import com.example.hw_1_7.data.Resource
import com.example.hw_1_7.response.door.DoorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    fun getDoors():LiveData<Resource<List<DoorModel.Data>>> = repository.getDoors()
}