package com.patinfly.data.dataSource.scooter

import android.annotation.SuppressLint
import android.content.Context
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.data.model.UserModel
import com.patinfly.domain.model.Scooter
import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class ScooterDao constructor(
) {
    private var context: Context? = null
    private var data:JSONArray?=null

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var instance: ScooterDao? = null
        fun getInstance(context: Context, data: JSONArray?) =
            instance ?: synchronized(this)
            {
                instance ?: ScooterDao().also {
                    instance = it
                    it.context =context
                    // assign coming data from Activity to data property
                    it.data = data
                }
            }
    }

    fun fetchScooters(): List<Scooter> {
        val scooterList = mutableListOf<Scooter>()

        data?.let {
            for (i in 0 until it.length()) {
                val scooter: JSONObject? = it.optJSONObject(i)
                scooter?.let {
                    val uuidString = it.optString("uuid")
                    val model = it.optString("model")
                    val serialNumber = it.optString("serialNumber")
                    val longitude = it.optDouble("longitude")
                    val latitude = it.optDouble("latitude")
                    val vacant = it.optBoolean("vacant")
                    val batteryLevel = it.optDouble("batteryLevel")
                    val batteryPartNumber = it.optString("batteryPartNumber")
                    val lastMaintenance = it.optString("lastMaintenance")

                    val uuid = UUID.fromString(uuidString)

                    if (vacant) {
                        val scooterObject = Scooter(
                            uuid = uuid,
                            model = model,
                            serialNumber = serialNumber,
                            longitude = longitude,
                            latitude = latitude,
                            vacant = vacant,
                            batteryLevel = batteryLevel,
                            batteryPartNumber = batteryPartNumber,
                            lastMaintenance = lastMaintenance
                        )
                        scooterList.add(scooterObject)
                    }
                }
            }
        }

        return scooterList
    }
}