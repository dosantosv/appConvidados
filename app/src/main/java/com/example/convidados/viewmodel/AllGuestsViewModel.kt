package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application.applicationContext)

    private val allGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = allGuests

    fun getall() {
        allGuests.value = repository.getAll()
    }
}