package com.curso.pa2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.curso.pa2.features.login.domain.DeleteUsernameCaseUse
import com.curso.pa2.features.login.domain.GetUsernameCaseUse
import com.curso.pa2.features.login.domain.SaveUsernameUseCase
import com.curso.pa2.features.login.domain.SignInUseCase

class LoginViewModel(
    private val signInUseCase: SignInUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val deleteUsernameCaseUse: DeleteUsernameCaseUse,
    private val getUsernameCaseUse: GetUsernameCaseUse

)  : ViewModel(){

    fun validateClicked(userName: String, password: String, rememberIsChecked: Boolean): Boolean {
        val isValid = signInUseCase.invoke(userName, password)
        if (rememberIsChecked) {
            saveUsernameUseCase.invoke(userName)
        }else{
            deleteUsernameCaseUse.invoke()
        }
        return isValid
    }

    fun onResumed(): String? {
        return getUsernameCaseUse.invoke()
        /*
        val username:String? = getUsernameCaseUse.invoke()
        /*if(username!=null){
            return username
        }
        return null*/
        username?.let{  //podría ser .apply y usaríamos this en lugar de it
            it //it = username no es nulo
        }*/
    }
}