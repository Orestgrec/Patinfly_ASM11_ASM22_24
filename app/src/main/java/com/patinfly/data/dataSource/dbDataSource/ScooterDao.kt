package com.patinfly.data.dataSource.dbDataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.patinfly.domain.model.dbDatasource.ScooterEntity
import java.util.UUID
@Dao
interface ScooterDao {
    @Insert
    suspend fun save(scooterEntity: ScooterEntity)
    @Query("select * from ScooterEntity where uuid = :uuid")
    suspend fun getScooterByUUID(uuid: UUID): ScooterEntity?

    @Query("select * from ScooterEntity")
    suspend fun getAll(): List<ScooterEntity>
    @Update
    fun update(scooterEntity: ScooterEntity)
    @Delete
    fun delete(scooterEntity: ScooterEntity)
}