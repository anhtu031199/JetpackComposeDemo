package com.tuna.jetpackcomposetutorial.messsage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MessageViewModel : ViewModel() {
    private val _sampleLiveData = MutableStateFlow("Hello!")
    val sampleLiveData: StateFlow<String> = _sampleLiveData

}
