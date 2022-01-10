package com.example.exceriseactivitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val resultConstract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                4 -> {
                    it.data?.let { data->
                        editTextName.setText(data.getStringExtra("KeyResultName"))
                    }
                }
                5 -> {
                        it.data?.let {data->
                        val year = data.getIntExtra("KeyResultDate", 0).toString()
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
        Log.i("TAG","")
    }

    override fun onResume() {
        super.onResume()
        buttonGetName.setOnClickListener {
            resultConstract.launch( Intent(this, NameActivity::class.java))
        }
        buttonGetDate.setOnClickListener {
            resultConstract.launch(Intent(this, YearActivity::class.java))
        }
    }
}
