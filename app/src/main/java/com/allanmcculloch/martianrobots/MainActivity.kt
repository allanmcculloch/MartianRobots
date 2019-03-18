package com.allanmcculloch.martianrobots

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        commandButton.setOnClickListener {
            var commands = commandsText.text.toString()

            try {
                val output = CommandParser().Execute(commands)
                resultText.text = output
            }
            catch (e : Exception) {
                resultText.text = e.message
            }
        }
    }
}
