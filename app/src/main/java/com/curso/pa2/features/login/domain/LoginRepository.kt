package com.curso.pa2.features.login.domain

interface LoginRepository {

    fun isValid(userName:String, password:String):Boolean
    fun saveUserName(userName: String)
    fun deleteUSername()
    fun getUsername():String?
}