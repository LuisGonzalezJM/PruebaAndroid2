package com.curso.pa2.features.login.domain


class GetUsernameCaseUse(private val loginRepository: LoginRepository) {

    operator fun invoke(): String? {
        return loginRepository.getUsername()
    }

}