package com.lel.cryptotrader_firebase.firestore.model

class Crypto(var name:String = "", var imageUrl:String = "", var avaible:Int = 0) {

    fun getDocumentId(): String {
        return name.toLowerCase()
    }
}