package com.curso.pa2.features.login.domain

class SaveUsernameUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(userName: String){
        loginRepository.saveUserName(userName)
    }


}