package com.patinfly.presentaion.scooterList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.usecase.GetScootersUseCase
import kotlinx.coroutines.launch

class ScooterViewModel(private val getScootersUseCase: GetScootersUseCase ) :ViewModel() {
    private var _scooters = MutableLiveData<List<Scooter>>()
    public val scooters: LiveData<List<Scooter>> = _scooters
    fun fetchScooters(context: Context) {
        viewModelScope.launch {
            try {
                val scootersList = getScootersUseCase.execute(context = context)
                _scooters.value = scootersList
            } catch (e: Exception) {
                // Handle error
                print("Some error at ScootersViewModel")
            }
        }
    }
}