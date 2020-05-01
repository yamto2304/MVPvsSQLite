package com.yamato.mymvpandsqlite.UI.SignUp

interface SignUpContact{
    interface View {
        fun signUpSuccess()
        fun signUpFailure(error: String)
    }

    interface Presenter{
        fun handleSignUp(username: String?, password: String?)
    }
}

