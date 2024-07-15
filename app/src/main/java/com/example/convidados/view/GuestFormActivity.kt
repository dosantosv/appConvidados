package com.example.convidados.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.model.GuestModel
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true
    }

    override fun onClick(v: View) {
        var isPresent: Boolean
        val name: String

        if (v.id == R.id.button_save) {
            name = binding.editName.text.toString()
            isPresent = binding.radioPresent.isChecked

            if (!isPresent)
                isPresent = binding.radioAbsent.isChecked

            viewModel.insert(GuestModel(1, name, isPresent))
        }
    }
}