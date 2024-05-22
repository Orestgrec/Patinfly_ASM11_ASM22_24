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
    fun save(rentEntity: RentEntity)
    @Query("select * from RentEntity where uuid = :uuid")
    fun getRentByUUID(uuid: UUID): RentEntity?

    @Query("select * from RentEntity")
    fun getAll(): List<RentEntity>
    @Update
    fun update(rentEntity: RentEntity)
    @Delete
    fun delete(rentEntity: RentEntity)

}