package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.model.FunctionResponse
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<FunctionResponse>()
    val saveGuest: LiveData<FunctionResponse> = _saveGuest

    fun save(guest: GuestModel) {
        val functionResponse = FunctionResponse(false)
        if(guest.id == 0) {
            functionResponse.sucess = repository.insert(guest)
            functionResponse.message = "Inserção feita com sucesso!"
        } else {
            functionResponse.sucess = repository.update(guest)
            functionResponse.message = "Atualização feita com sucesso!"
        }
    }

    fun get(id : Int) {
        guestModel.value = repository.get(id)
    }
}