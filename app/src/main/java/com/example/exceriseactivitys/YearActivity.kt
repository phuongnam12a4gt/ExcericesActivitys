package com.example.exceriseactivitys

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_date.*

class YearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
    }

    override fun onResume() {
        super.onResume()
        buttonOke.setOnClickListener {
            val intent = Intent()
            intent.putExtra("KeyResultDate", editTextYear.text.toString().toInt())
            setResult(5, intent)
            finish()
        }
    }
}
