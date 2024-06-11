package com.patinfly.domain.model.remotedDataSource

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class StatusInfo(
    @SerialName(value = "version")
    val version: String = "0.0",

    @SerialName(value = "build")
    val build: String = "0",

    @SerialName(value = "update")
    val update: String = "2023-05-07T21:50:58.621408Z",

    @SerialName(value = "name")
    val name: String = "testing"
)

@Serializable
data class StatusApiModel(
    @SerialName(value = "status")
    val status: StatusInfo
) {
    fun toStatusDomain(): StatusApiModel {
          return StatusApiModel(status = StatusInfo(
              version = status.version,build = status.build,update = status.update,name = status.name))
    }
}