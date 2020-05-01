package com.yamato.mymvpandsqlite.UI.SignIn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yamato.mymvpandsqlite.R
import com.yamato.mymvpandsqlite.UI.Main.MainActivity
import com.yamato.mymvpandsqlite.UI.SignUp.SignUpActivity


class SignInActivity : AppCompatActivity(), View.OnClickListener, SignInContract.View {
    private lateinit var mTextUsername : EditText
    private lateinit var mTextPassword : EditText
    private lateinit var mButtonSignIn : Button
    private lateinit var mButtonSignUp : Button
    private lateinit var mSignInPresenter : SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initView()
        registerListener()
        initPresenter()
    }

    private fun initView(){
        mTextUsername = findViewById(R.id.text_username)
        mTextPassword = findViewById(R.id.text_password)
        mButtonSignIn = findViewById(R.id.button_sign_in)
        mButtonSignUp = findViewById(R.id.button_sign_up)
    }

    private fun registerListener(){
        mButtonSignUp.setOnClickListener(this)
        mButtonSignIn.setOnClickListener(this)
    }

    private fun initPresenter(){
        mSignInPresenter = SignInPresenter()
        mSignInPresenter.setView(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_sign_in -> login()
            R.id.button_sign_up -> startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
            }
        }

    override fun signInSuccess() {
        Toast.makeText(this, "Sign In Success!", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun signInFailure(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun login(){
        var username : String = mTextUsername.text.toString()
        var password : String = mTextPassword.text.toString()
        if(username.isEmpty()|| password.isEmpty()){
            Toast.makeText(this, "Username or Password is Empty !", Toast.LENGTH_SHORT).show()
            return
        }
        mSignInPresenter.handleSignIn(username, password)
    }
}


