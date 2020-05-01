package com.yamato.mymvpandsqlite.UI.SignIn

    interface SignInContract {
        interface View {
            fun signInSuccess()
            fun signInFailure(error: String?)
        }

    interface Presenter {
            fun handleSignIn(username: String?, password: String?)
        }
    }
