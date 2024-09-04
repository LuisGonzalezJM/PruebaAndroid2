package com.curso.pa2.features.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.curso.pa2.R
import com.curso.pa2.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory: LoginFactory
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginFactory = LoginFactory(this)
        loginViewModel = loginFactory.provideLoginViewModel()
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.boton)
        actionValidate.setOnClickListener {
            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val rememberIsChecked = findViewById<CheckBox>(R.id.checkRemember).isChecked
            val isValid = loginViewModel.validateClicked(userName, password, rememberIsChecked)
            if (isValid){
                Snackbar.make(findViewById<View>(R.id.main), R.string.message_login_ok, Snackbar.LENGTH_SHORT).show()
                //setContentView(R.layout.activity_main)
            }else{
                Snackbar.make(findViewById<View>(R.id.main), R.string.message_login_ko, Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}