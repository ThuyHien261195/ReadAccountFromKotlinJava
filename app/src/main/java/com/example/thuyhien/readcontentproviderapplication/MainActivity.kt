package com.example.thuyhien.readcontentproviderapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AccountCallBackListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AccountLoader.loadAccount(this)
    }

    override fun onLoadAccountSuccess(account: Account?) {
        if (account == null) {
            Toast.makeText(this, "Error get Account", Toast.LENGTH_LONG).show()
        } else {
            tvUser.text = account.user
            tvPass.text = account.password
        }
    }
}
