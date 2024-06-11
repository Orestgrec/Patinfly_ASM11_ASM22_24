package com.patinfly.data.dataSource.remoteDbDataSource


import com.patinfly.domain.model.remotedDataSource.RentApiModel
import com.patinfly.domain.model.remotedDataSource.ScooterApiModel
import com.patinfly.domain.model.remotedDataSource.StatusApiModel
import retrofit2.http.GET
import retrofit2.http.Header

interface APIService {

    @GET("status")
    suspend fun getServerStatus(): StatusApiModel

    @GET("endpoints/scooter")
    suspend fun getScooters(@Header("api-key") token: String): ScooterApiModel

    @GET("endpoints/rent")
    suspend fun getRents(@Header("api-key") token: String): RentApiModel
}
