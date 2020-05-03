package com.ezyindustries.smkcoding_challenge1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getData()

        btnEditName.setOnClickListener { goToProfilePage() }

        btnCall.setOnClickListener { dialPhone(txtTelp.text.toString()) }

        btnAbout.setOnClickListener { goToAboutPage() }
    }

    private fun getData() {

        val bundle = intent.extras

        val nama = bundle.getString("nama")
        val gender = bundle.getString("gender")
        val email = bundle.getString("email")
        val umur = bundle.getString("umur")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")

        txtName.text = nama
        txtGender.text = gender
        txtEmail.text = email
        txtUmur.text = umur + " tahun"
        txtTelp.text = telp
        txtAddress.text = alamat
    }

    private fun goToProfilePage() {
        val intent = Intent(this, EditProfileActivity::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }

    private fun goToAboutPage() {
        val intent = Intent(this,AboutActivity::class.java)
        startActivity(intent)
    }

    private fun dialPhone(phoneNumber:String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{
                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

}
