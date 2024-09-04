package com.curso.pa2.features.login

import android.content.Context
import com.curso.pa2.features.login.data.LoginDataRepository
import com.curso.pa2.features.login.data.local.LoginXmlLocalDataSource
import com.curso.pa2.features.login.data.remote.LoginMockRemoteDataSource
import com.curso.pa2.features.login.domain.LoginRepository
import com.curso.pa2.features.login.domain.SaveUsernameUseCase
import com.curso.pa2.features.login.domain.SignInUseCase
import com.curso.pa2.features.login.presentation.LoginViewModel

class LoginFactory (private val context: Context) {

    private val loginMockRemoteDataSource:LoginMockRemoteDataSource = provideLoginMockRemoteDataSource()
    private val loginDataRepository: LoginRepository = provideLoginDataRepository()
    private val loginXmlLocalDataSource: LoginXmlLocalDataSource = provideLoginXmlLocalDataSource()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()
    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()

    fun provideLoginViewModel() : LoginViewModel {
        return LoginViewModel(signInUseCase, saveUsernameUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }
    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource{
        return LoginXmlLocalDataSource(context)
    }

    private fun provideLoginDataRepository(): LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource, loginXmlLocalDataSource)
    }

    fun provideSaveUsernameUseCase(): SaveUsernameUseCase{
        return SaveUsernameUseCase(loginDataRepository)

    }
    fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase(loginDataRepository)
    }
}