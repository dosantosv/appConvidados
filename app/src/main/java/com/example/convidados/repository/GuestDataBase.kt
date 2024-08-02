package com.example.convidados.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.convidados.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var instance: GuestDataBase

        fun getDataBase(context: Context): GuestDataBase {
            if(!::instance.isInitialized) {
                synchronized(GuestDataBase::class) {
                    instance = Room.databaseBuilder(context, GuestDataBase::class.java, "guestdb")
                        .addMigrations(migration_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }

        private val migration_1_2: Migration = object: Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                TODO("Not yet implemented")
            }

        }
    }
}