package com.curso.pa2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.curso.pa2.features.login.domain.SaveUsernameUseCase
import com.curso.pa2.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase, private val saveUsernameUseCase: SaveUsernameUseCase)  : ViewModel(){

    fun validateClicked(userName:String, password:String, rememberIsChecked: Boolean):Boolean{
        val isValid=signInUseCase.invoke(userName, password)
        if(rememberIsChecked){
            saveUsernameUseCase.invoke(userName)
        }
        return isValid
    }
}