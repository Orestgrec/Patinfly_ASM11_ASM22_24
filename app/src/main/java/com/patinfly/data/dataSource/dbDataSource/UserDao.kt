package com.patinfly.data.dataSource.dbDataSource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.patinfly.domain.model.dbDatasource.UserEntity
import java.util.UUID
//DBUserDataSource
 @Dao
interface UserDao {
// CRUD Methods: Create, Request, Update and Delete
 @Insert
 suspend fun save(userEntity: UserEntity)
 @Query("select * from UserEntity where uuid = :uuid")
 suspend fun getUserByUUID(uuid: UUID): UserEntity?
 @Query("select * from UserEntity where email = :email")
 suspend fun getUserByMail(email: String): UserEntity?
 @Query("select * from UserEntity")
 suspend fun getAll(): List<UserEntity>
 @Update
 suspend fun update(userEntity: UserEntity)
 @Delete
 suspend fun delete(userEntity:UserEntity)

 }