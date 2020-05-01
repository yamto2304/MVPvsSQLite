package com.yamato.mymvpandsqlite.UI.SignUp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yamato.mymvpandsqlite.R
import com.yamato.mymvpandsqlite.UI.Main.MainActivity
import com.yamato.mymvpandsqlite.UI.SignIn.SignInActivity


class SignUpActivity : AppCompatActivity(), SignUpContact.View, View.OnClickListener {
    private lateinit var mTextUsername : EditText
    private lateinit var mTextEmail : EditText
    private lateinit var mTextPassword : EditText
    //tam thoi chi quan tam Username va Email de dang ki
    private lateinit var mButtonSignIn : Button
    private lateinit var mButtonSignUp : Button
    private lateinit var mSignUpPresenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initView()
        registerListener()
        initPresenter()
    }

    private fun initView(){
        mTextUsername = findViewById(R.id.importUsername)
        mTextPassword = findViewById(R.id.importPassword)
        mTextEmail = findViewById(R.id.importEmail)
        mButtonSignUp = findViewById(R.id.btnRegister)
        mButtonSignIn = findViewById(R.id.btnBackToLogin)
    }

    private fun registerListener(){
        mButtonSignIn.setOnClickListener(this)
        mButtonSignUp.setOnClickListener(this)
    }

    private fun initPresenter(){
        mSignUpPresenter = SignUpPresenter()
        mSignUpPresenter.setView(this)
    }

    override fun signUpSuccess() {
        Toast.makeText(this, "Sign Up Success !", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun signUpFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnBackToLogin -> startActivity(Intent(this, SignInActivity::class.java))
            R.id.btnRegister -> register()
        }
    }

    private fun register(){
        var username : String = mTextUsername.text.toString()
        var email : String = mTextEmail.text.toString()
        var password : String = mTextPassword.text.toString()
        //auth
        if(username.isEmpty()|| email.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Please fill your all information !", Toast.LENGTH_SHORT).show()
            return
        }
        mSignUpPresenter.handleSignUp(username, email)
    }
}