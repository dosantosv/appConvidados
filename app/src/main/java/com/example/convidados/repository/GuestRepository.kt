package com.example.convidados.repository

import android.content.Context
import com.example.convidados.model.GuestModel

class GuestRepository(context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()

    fun insert(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) {
        val guests = get(id)
        guestDataBase.delete(guests)
    }

    fun get(guestId: Int) : GuestModel {
        return guestDataBase.get(guestId)
    }

    fun getAll() : List<GuestModel> {
        return guestDataBase.getAll()
    }

    fun getIsPresent(isPresent : Int) : List<GuestModel> {
        return guestDataBase.getIsPresent(isPresent)
    }
}






