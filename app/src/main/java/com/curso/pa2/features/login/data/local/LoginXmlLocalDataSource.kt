package com.curso.pa2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context){

    val sharedPref = context.getSharedPreferences("username", Context.MODE_PRIVATE)
    val keyUsername = "key_username"

    fun saveUsername(username:String){
        val editor=sharedPref.edit()
        editor.putString(keyUsername, username)
        editor.commit()
    }

    fun deleteUserName(){
        val editor = sharedPref.edit()
        editor.remove(keyUsername)
        editor.commit()

        //Método habitual en Kotlin
        //Scope Function: apply
        //sharedPref.edit().apply{
        //  remove("key_username")
        //  copmmit()
        //}
    }

    fun getUsername():String?{
        return sharedPref.getString(keyUsername,null)
    }
}