package com.patinfly.presentation.scooterList

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.remotedDataSource.StatusApiModel
import com.patinfly.domain.usecase.GetRemoteScooterUsecase
import com.patinfly.domain.usecase.GetScooterUsecase
import com.patinfly.domain.usecase.InsertScooterUsecase
import com.patinfly.domain.usecase.ServerStatusUsecase
import kotlinx.coroutines.launch

class ScooterViewModel(private val getScootersUseCase: GetScooterUsecase,private val insertScooterUsecase: InsertScooterUsecase) :ViewModel() {
    private var _scooters = MutableLiveData<List<Scooter>?>()
    public val scooters: LiveData<List<Scooter>?> = _scooters

    private var _test = MutableLiveData<String>()
    public val test: LiveData<String> = _test
    fun fetchScooters(context: Context) {
        viewModelScope.launch {
            try {
                val status: StatusApiModel? = ServerStatusUsecase.execute(context = context)
                var scootersList :List<Scooter>? = getScootersUseCase.execute(context = context)
                Log.e("TAG check hah",scootersList?.isEmpty().toString())

                if (scootersList?.isEmpty() == true){
                   scootersList = GetRemoteScooterUsecase.execute(context=context)?.scooters?.map { it.fromScooterDomain() }
                    scootersList?.forEach{
                        insertScooterUsecase.execute(it,context)
                    }
                }
                _test.value = status?.status?.update
                _scooters.value = scootersList
            } catch (e: Exception) {
                // Handle error
                print("Some error at ScootersViewModel")
            }
        }
    }
}