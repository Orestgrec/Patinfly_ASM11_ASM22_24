package com.patinfly.presentation.rentList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patinfly.domain.model.Rent
import com.patinfly.domain.usecase.GetRentsUsecase
import kotlinx.coroutines.launch

class RentViewModel(private val getRentListUsecase: GetRentsUsecase) : ViewModel() {
    private var _rents = MutableLiveData<List<Rent>>()
    public val rents: LiveData<List<Rent>> = _rents
    fun fetchRents(context: Context) {
        viewModelScope.launch {
            try {
                val rentList = getRentListUsecase.execute(context = context)
                _rents.value = rentList
            } catch (e: Exception) {
                // Handle error
                print("Some error at ScootersViewModel")
            }
        }
    }
}