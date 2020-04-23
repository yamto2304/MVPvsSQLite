package com.yamato.mymvpandsqlite.UI.SignIn

class SignInPresenter : SignInContract.Presenter{
    private lateinit var mView : SignInContract.View
    fun setView(view: SignInContract.View){
        mView = view
    }

    override fun handleSignIn(username: String?, password: String?) {
        if(username.equals("Ymt")&& password.equals("123456")){
            mView.signInSuccess()
            return
        }

        mView.signInFailure("Username or Password not true !")
    }
}