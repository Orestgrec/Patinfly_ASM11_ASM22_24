package com.patinfly.presentation.rentList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patinfly.domain.model.Rent
import com.patinfly.domain.usecase.GetRemoteRentUsecase
import com.patinfly.domain.usecase.GetRentsUsecase
import com.patinfly.domain.usecase.InsertRentUsecase
import kotlinx.coroutines.launch

class RentViewModel(private val getRentListUsecase: GetRentsUsecase,private val insertRentUsecase: InsertRentUsecase) : ViewModel() {
    private var _rents = MutableLiveData<List<Rent>?>()
    public val rents: LiveData<List<Rent>?> = _rents

    fun fetchRents(context: Context) {
        viewModelScope.launch {
            try {
                var rentsList :List<Rent>? = getRentListUsecase.execute(context = context)
                Log.e("TAG check hah",rentsList?.isEmpty().toString())

                if (rentsList?.isEmpty() == true){
                    rentsList = GetRemoteRentUsecase.execute(context=context)?.rents?.map { it.fromRentDomain() }
                    rentsList?.forEach{
                        insertRentUsecase.execute(it,context)
                    }
                }
                _rents.value = rentsList
            } catch (e: Exception) {
                // Handle error
                print("Some error at ScootersViewModel")
            }
        }
    }
}