package com.curso.pa2.features.login

import com.curso.pa2.features.login.data.LoginDataRepository
import com.curso.pa2.features.login.data.remote.LoginMockRemoteDataSource
import com.curso.pa2.features.login.domain.LoginRepository
import com.curso.pa2.features.login.domain.SignInUseCase
import com.curso.pa2.features.login.presentation.LoginViewModel

class LoginFactory {

    private val loginMockRemoteDataSource:LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginDataRepository: LoginRepository = provideLoginDataRepository()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    fun provideLoginViewModel() : LoginViewModel {
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginDataRepository)
    }
}