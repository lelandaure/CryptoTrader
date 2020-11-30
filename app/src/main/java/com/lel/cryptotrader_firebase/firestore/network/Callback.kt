package com.lel.cryptotrader_firebase.firestore.network

import java.lang.Exception

interface Callback<T> {
    fun onSuccess(resultado: T?)

    fun onFailed(exception: Exception)
}