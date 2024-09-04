package com.curso.pa2.features.login.domain

class SignInUseCase (private val loginRepository: LoginRepository){

    operator fun invoke(userName: String, password: String): Boolean {
        return this.loginRepository.isValid(userName, password)

    }
}