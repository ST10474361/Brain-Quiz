package com.example.brainquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button

class Review: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review)

        val exitButton = findViewById<Button>(R.id.exitButton)


        exitButton.setOnClickListener {
            finishAffinity() // Close all activities of the app
        }
    }
}
