package com.curso.pa2.features.login.domain


class DeleteUsernameCaseUse(private val loginRepository: LoginRepository) {

    operator fun invoke() {
        loginRepository.deleteUSername()
    }

}