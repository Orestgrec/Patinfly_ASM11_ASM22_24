package com.patinfly.data.dataSource.dbDataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.patinfly.domain.model.dbDatasource.RentEntity
import java.util.UUID
@Dao
interface RentDao {

    @Insert
    suspend fun save(rentEntity: RentEntity)
    @Query("select * from RentEntity where uuid = :uuid")
    suspend fun getRentByUUID(uuid: UUID): RentEntity?

    @Query("select * from RentEntity")
    suspend fun getAll(): List<RentEntity>
    @Update
    suspend fun update(rentEntity: RentEntity)
    @Delete
    suspend fun delete(rentEntity: RentEntity)

}