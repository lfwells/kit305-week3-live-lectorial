package com.example.week3lectorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


const val RESULT_GOT_NAME = 1
const val RESULT_CANCEL = 0

const val KEY_USER_NAME = "USER_NAME"

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnOK = findViewById<Button>(R.id.btnOK)
        btnOK.setOnClickListener {
            val name = findViewById<EditText>(R.id.txtNames).text.toString()

            val data = Intent()
            data.putExtra(KEY_USER_NAME, name)
            setResult(RESULT_GOT_NAME, data)
            finish()
        }

        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            setResult(RESULT_CANCEL)
            finish()
        }
    }
}