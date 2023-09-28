package com.imsoft.simplechronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.imsoft.simplechronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var runnable: Runnable = Runnable {  }
    private var handler: Handler = Handler(Looper.getMainLooper())
    private  var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startBtn (view: View) {
        number = 0

        runnable = object : Runnable {
            override fun run() {
                number ++
                binding.textView.text = "Time: ${number}"

                handler.postDelayed(this, 1000)

                binding.button.isEnabled = false
            }
        }

        handler.post(runnable)
    }

    fun stopBtn (view: View) {
        binding.button.isEnabled = true
//        number = 0
        binding.textView.text = "Time: 0"
        handler.removeCallbacks(runnable)
    }
}