package com.patinfly.data.dataSource.dbDataSource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patinfly.domain.model.dbDatasource.RentEntity
import com.patinfly.domain.model.dbDatasource.ScooterEntity
import com.patinfly.domain.model.dbDatasource.UserEntity

@Database(entities = [UserEntity::class,RentEntity::class,ScooterEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDataSource(): UserDao
    abstract fun rentDataSource(): RentDao
    abstract fun scooterDataSource(): ScooterDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "patinfly_24_database v8"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
