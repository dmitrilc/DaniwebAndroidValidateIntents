package com.example.daniwebandroidvalidateintents

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_launchIntent).setOnClickListener {
            val intent = Intent(ACTION_VIEW).apply {
                data = intentData
            }

            startActivity(intent)
        }
    }

    companion object {
        val intentData: Uri = Uri.Builder()
            .scheme("geo")
            .query("0,0")
            .appendQueryParameter("q", "First St SE, Washington, DC, 20004")
            .build()
    }
}