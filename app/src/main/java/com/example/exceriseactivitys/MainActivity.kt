package com.example.exceriseactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val resultConstract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                4 -> {
                    val intent = it.data
                    intent?.let {
                        editTextName.setText(intent.getStringExtra("KeyResultName"))
                    }
                }
                5 -> {
                    val intent = it.data
                    intent?.let {
                        val year = intent.getIntExtra("KeyResultDate", 0).toString()
                        editTextDate.setText(year)
                        val currentTime: Int = Calendar.getInstance().get(Calendar.YEAR)
                        editTextAge.setText((currentTime - year.toInt()).toString())
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        buttonGetName.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            resultConstract.launch(intent)
        }
        buttonGetDate.setOnClickListener {
            val intent = Intent(this, YearActivity::class.java)
            resultConstract.launch(intent)
        }
    }
}
