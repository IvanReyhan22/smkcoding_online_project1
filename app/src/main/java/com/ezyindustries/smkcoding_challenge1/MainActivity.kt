package com.ezyindustries.smkcoding_challenge1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var namaInput : String = ""
    private var emailInput : String = ""
    private var umurInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGener()

        btnSave.setOnClickListener { validasiInput() }

    }

    private fun validasiInput() {

        namaInput = edtName.text.toString()
        emailInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        umurInput = edtUmur.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            umurInput.isEmpty() -> edtUmur.error = "Umur tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"

            else -> {
                tampilToast("Selamat datang " + namaInput)
                goToProfileActivity()
            }
        }

    }

    private fun setDataSpinnerGener() {
        var adapter = ArrayAdapter.createFromResource(this,R.array.jenis_kelamin, android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter
    }

    private fun goToProfileActivity() {
        val intent = Intent(this,ProfileActivity::class.java)

        val bundle =  Bundle()
        bundle.putString("nama",namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("umur", umurInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
