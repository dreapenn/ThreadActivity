package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val timerTextView : TextView by lazy{
        findViewById(R.id.timerTextView)
    }
    val button : Button by lazy{
        findViewById(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            CoroutineScope(Job() + Dispatchers.Default).launch {
                for (i in 100 downTo (1)) {
                    Log.d("Countdown", i.toString())
                    withContext(Dispatchers.Main){
                        timerTextView.text = i.toString()
                    }
                    delay(1000)
                }
            }

        }





    }



}