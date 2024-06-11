package com.patinfly.data.dataSource.remoteDbDataSource

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import retrofit2.Retrofit
import com.patinfly.domain.model.remotedDataSource.ScooterApiModel
import com.patinfly.domain.model.remotedDataSource.StatusApiModel
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.gson.GsonConverterFactory

class ScooterAPIDataSource private constructor() {

    private var context: Context? = null

    companion object {
        private const val BASE_URL = "https://patinfly.com/"
        private lateinit var retrofit: APIService

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ScooterAPIDataSource? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: ScooterAPIDataSource().also {
                    instance = it
                    it.context = context
                    val contentType = "application/json".toMediaType()
                    retrofit = Retrofit.Builder()
                        //.addConverterFactory(Json.asConverterFactory(contentType))
                        //.addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                        .create(APIService::class.java)
                }
            }
    }

    suspend fun getStatus(): StatusApiModel {
            val status = retrofit.getServerStatus()
            Log.d("ScooterAPIDataSource", "$status")
            return status
    }
    suspend fun getScooters(): ScooterApiModel  {
            val scooters = retrofit.getScooters("cXwoo4aCs8VKooJyX2ddGQF1WLOjdwNpGvbazLVM2AWAJxVuTy23")
            Log.d("ScooterAPIDataSource", "$scooters")
            return scooters
    } }