package com.lel.cryptotrader_firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

const val USERNAME_KEY = "username_key"

class LoginActivity : AppCompatActivity() {


    private val TAG = "LoginActivity"

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun onStartClicked(view: View) {

        auth.signInAnonymously().addOnCompleteListener {task ->
            if (task.isSuccessful){
                var username = username.text.toString()
                startMainActivity(username)
            }else{
                showErrorMessage(view)
            }
        }


    }

    private fun showErrorMessage(view: View) {
        Snackbar.make(view, getString(R.string.error_while_connecting_to_the_server), Snackbar.LENGTH_LONG)
            .setAction("Info", null).show()
    }

    private fun startMainActivity(username: String) {
        val intent = Intent(this@LoginActivity, TraderActivity::class.java)
        intent.putExtra(USERNAME_KEY, username)
        startActivity(intent)
        finish()
    }

}