package com.ezyindustries.smkcoding_challenge1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_profile.*

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val intentData = intent.extras
        val namaUser = intentData.getString("nama")

        edtProfilName.setText(namaUser)

        btnEditSave.setOnClickListener { saveData() }

    }

    private fun saveData() {

        val namaEdit = edtProfilName.text.toString()

        if (!namaEdit.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()

    }


}
