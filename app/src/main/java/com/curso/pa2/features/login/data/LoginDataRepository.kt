package com.curso.pa2.features.login.data

import androidx.core.view.ViewPropertyAnimatorUpdateListener
import com.curso.pa2.features.login.data.local.LoginXmlLocalDataSource
import com.curso.pa2.features.login.data.remote.LoginMockRemoteDataSource
import com.curso.pa2.features.login.domain.LoginRepository

class LoginDataRepository(
    private val remoteDataSource: LoginMockRemoteDataSource,
    private val localDataSource: LoginXmlLocalDataSource
):LoginRepository{
    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName, password)
    }

    override fun saveUserName(userName: String) {
        localDataSource.saveUsername(userName)
    }

    override fun deleteUSername() {
        localDataSource.deleteUserName()
    }

    override fun getUsername(): String? {
        return localDataSource.getUsername()
    }


}