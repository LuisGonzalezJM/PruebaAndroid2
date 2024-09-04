package com.curso.pa2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.curso.pa2.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase)  : ViewModel(){

    fun validateClicked(userName:String, password:String):Boolean{
        val isValid=signInUseCase.invoke(userName, password)
        return isValid
    }
}