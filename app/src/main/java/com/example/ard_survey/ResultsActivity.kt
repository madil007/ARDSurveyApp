package com.example.ard_survey

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ard_survey.model.DisplayModel
import com.example.ard_survey.model.ModelResponse
import com.example.mvvmkotlinexample.viewmodel.MainActivityViewModel

class ResultsActivity : AppCompatActivity() {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: ARDSurveryAdapter
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var list: MutableList<ModelResponse>
    private lateinit var displayList: MutableList<DisplayModel>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        list= ArrayList<ModelResponse>()
        displayList= ArrayList<DisplayModel>()
        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("ARD Survey")
        progressDialog.setMessage("please wait...")
        progressDialog.setCanceledOnTouchOutside(false)

        val textView = findViewById<TextView>(R.id.results_textView)
        val saveButton = findViewById<Button>(R.id.button_save_results)
        val restartButton = findViewById<Button>(R.id.button_restart)
        val homeButton = findViewById<Button>(R.id.button_home_results)
        val recyclerView = findViewById<RecyclerView>(R.id.overlay_layout)







        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]


            //  wp7progressBar.showProgressBar()
            progressDialog.show()

            mainActivityViewModel.getUser()!!.observe(this, Observer { response ->

                for (i in 0 until response.items?.size!!) {
                    val url = response.items[i]?.images?.get(0)?.url
                    val videolink = response.items[i]?.links?.android
                    displayList.add(DisplayModel(url.toString(),videolink))
                }

                //   wp7progressBar.hideProgressBar()
                progressDialog.dismiss()
                list.add(response)
                recyclerView.layoutManager= androidx.recyclerview.widget.LinearLayoutManager(this)
                adapter= ARDSurveryAdapter(this,displayList)
                recyclerView.adapter=adapter

            })





        saveButton.setOnClickListener {
            //
        }

        //kann man das besser machen?
        restartButton.setOnClickListener {
            finish()
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK) //to make sure that all previous activities are closed
            startActivity(intent)
            finish()
        }
    }
}
