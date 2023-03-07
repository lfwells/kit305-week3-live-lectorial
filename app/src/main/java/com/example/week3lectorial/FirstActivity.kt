package com.example.week3lectorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class FirstActivity : AppCompatActivity() {

    val getNameResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result : ActivityResult ->
        //this is when we come back from the next screen
        if (result.resultCode == RESULT_GOT_NAME)
        {
            Log.d("MY_COOL_APP", result.resultCode.toString() + " " + result.data?.getStringExtra(KEY_USER_NAME))
        }
        else
        {
            Log.d("MY_COOL_APP", "cancelled"+result.resultCode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            //open the next page
            //intent -> user intends to do something

            val openNameSelectScreenIntent = Intent(this, SecondActivity::class.java)
            //openNameSelectScreenIntent.putExtra("productID", 45454)
            //startActivity(openNameSelectScreenIntent)

            //we are going to get a result (name) from the name select screen
            getNameResult.launch(openNameSelectScreenIntent)
        }
    }
}