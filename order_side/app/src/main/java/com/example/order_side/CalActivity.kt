package com.example.order_side

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)




        //キャンセルボタン
        val cancel = findViewById<Button>(R.id.cancel)

        cancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val price = intent.getIntExtra("PRICE")
            startActivity(intent)
        }
    }
}
