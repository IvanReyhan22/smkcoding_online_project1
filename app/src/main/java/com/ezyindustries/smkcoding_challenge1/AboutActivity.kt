package com.ezyindustries.smkcoding_challenge1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        txtName.text = "Ahmad Ivan Reyhan"
        txtEmail.text = "ivanreyhan2002@gmail.com"
        txtTelp.text = "081336227548"
        txtAlamat.text = "Jln I.R Rais 80 Malang"
    }
}
