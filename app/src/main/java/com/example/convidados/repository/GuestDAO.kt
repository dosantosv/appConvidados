package com.example.convidados.repository

import androidx.room.Dao
import androidx.room.Insert
import com.example.convidados.model.GuestModel

@Dao
interface GuestDAO {

    @Insert
    fun insert(guest: GuestModel)
}