package com.example.mytimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTimer = findViewById<TextView>(R.id.tv_timer)
        var edNumber = findViewById<EditText>(R.id.etNumber)
        val buttonStart = findViewById<Button>(R.id.bt_start)
        var timeStart = System.currentTimeMillis()
        var timeFinish = System.currentTimeMillis()
        val mainHandler = Handler(Looper.getMainLooper())

        fun startTimerFun (){

            buttonStart.isEnabled = false
            timeStart = System.currentTimeMillis()
            timeFinish = System.currentTimeMillis() + edNumber.text.toString().toLong()
            tvTimer.setText(edNumber.text)
            edNumber.setText(timeFinish.toString())

        }

        fun stopTimerFun (){

        }

        fun timerCycle () {


        }


        buttonStart.setOnClickListener {
            val threadTimer = Thread {

                mainHandler.postDelayed(
                    object : Runnable {
                        override fun run() {
                            startTimerFun ()

                        }
                    }, 1000L
                )
            }
            threadTimer.start()

        }

    }
}