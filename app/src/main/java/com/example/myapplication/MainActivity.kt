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
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val timerHandler = Handler(Looper.getMainLooper()){
        timerTextView.text = it.what.toString()

        true
    }

    val timerTextView : TextView by lazy{
        findViewById(R.id.timerTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            for(i in 100 downTo (1)){
                Log.d("Countdown", i.toString())
                Thread.sleep(1000)
                timerHandler.sendEmptyMessage(i)
            }
        }.start()


    }

}