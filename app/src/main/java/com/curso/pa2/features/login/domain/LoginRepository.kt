package com.curso.pa2.features.login.domain

interface LoginRepository {

    fun isValid(userName:String, password:String):Boolean
}