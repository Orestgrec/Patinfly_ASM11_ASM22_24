package com.patinfly.domain.model.dbDatasource

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.patinfly.domain.model.User
import java.util.Date
import java.util.UUID
@Entity
data class UserEntity (
    @PrimaryKey val uuid: UUID,
    val username: String,
    val email: String,
    val isRenting: Boolean,
    val scooterRented: UUID?,
    val creationDate: String,
    val numberOfRents: Int,
    val salt :String,
    val hashedPass:String)
{
    companion object {
        fun fromUserDomain(user: User): UserEntity {
            return UserEntity(uuid = user.uuid,username = user.username,email = user.email,isRenting = user.isRenting,scooterRented = user.scooterRented,creationDate = user.creationDate.toString(),numberOfRents = user.numberOfRents, salt=user.salt, hashedPass = user.hashedPass )        }    } }
fun UserEntity.toUserDomain(): User{
    return User(
        uuid = uuid,
        username = username
        ,email = email
        ,isRenting = false
        ,scooterRented = scooterRented
        ,creationDate = Date()
        ,numberOfRents = numberOfRents,
        salt = salt,
        hashedPass = hashedPass
    ) }