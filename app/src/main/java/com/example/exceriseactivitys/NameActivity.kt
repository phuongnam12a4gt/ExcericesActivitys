package com.example.exceriseactivitys

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
    }

    override fun onResume() {
        super.onResume()
        buttonOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("KeyResultName", editName.text.toString())
            setResult(4, intent)
            finish()
        }
    }
}
