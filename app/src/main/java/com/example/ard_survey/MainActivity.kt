package com.example.ard_survey

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmkotlinexample.viewmodel.MainActivityViewModel

//Serge Kommentar
class MainActivity : AppCompatActivity() {
    private lateinit var buttonAccount: Button
    private lateinit var buttonOptions: Button
    private lateinit var buttonStart: Button
    private lateinit var buttonSavedStuff: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Initialisiere die Views
        buttonAccount = findViewById(R.id.button_account)
        buttonOptions = findViewById(R.id.button_Optionen)
        buttonStart = findViewById(R.id.button_start)
        buttonSavedStuff = findViewById(R.id.button_saved_stuff)



        // Setze Klick-Listener für die Buttons
        buttonAccount.setOnClickListener {
            // Wechsel zur gewünschten Activity (Ziel muss noch spezifiziert werden)
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }



//        buttonOptions.setOnClickListener {
//            // Wechsel zur gewünschten Activity (Ziel muss noch spezifiziert werden)
//           // val intent = Intent(this, ZielActivity::class.java)
//            startActivity(intent)
//        }

        buttonStart.setOnClickListener {
            // Wechsel zur gewünschten Activity (Ziel muss noch spezifiziert werden)
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

        buttonSavedStuff.setOnClickListener {
            // Wechsel zur gewünschten Activity (Ziel muss noch spezifiziert werden)
            //val intent = Intent(this, ZielActivity::class.java)
            startActivity(intent)
        }
    }
}
