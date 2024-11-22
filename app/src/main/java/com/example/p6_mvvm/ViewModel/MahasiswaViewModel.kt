package com.example.praktikum7.viewmodel

import androidx.lifecycle.ViewModel
import com.example.p5_mvvm.ui.theme.Model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class MahasiswaViewModel : ViewModel() {
    // Request
    private val _statusUI = MutableStateFlow(Mahasiswa())
    // Response
    val statusUI: StateFlow<Mahasiswa> = _statusUI.asStateFlow()

    fun setMahasiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                nim = ls[1],
                email = ls[2],
            )
        }
    }
}
