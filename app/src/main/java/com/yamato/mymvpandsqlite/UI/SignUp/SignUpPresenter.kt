package com.yamato.mymvpandsqlite.UI.SignUp

class SignUpPresenter : SignUpContact.Presenter {
    private lateinit var mView: SignUpContact.View
    fun setView(view: SignUpContact.View) {
        mView = view
    }

    override fun handleSignUp(username: String?, email: String?) {
        if (!username.equals("Ymt")&& !email.equals("Tuntun")) {
            mView.signUpSuccess()
            return
        }
        if(username.equals("Ymt")){
            mView.signUpFailure("Username already exist !")
        } else{
            mView.signUpFailure("Email has been used !")
        }

    }
}