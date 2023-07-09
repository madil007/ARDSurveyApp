package com.example.ard_survey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class SurveyActivity : AppCompatActivity() {

    //Testbool
   // var q2_answer: Boolean? = null      //true=Ja, false=Nein, null=don't care


    //counter für das rotieren der Fragen
    private var counter: Int = 1

    //Views für Jede Frage
    private lateinit var buttonBackSurvey: Button
    private lateinit var buttonHomeSurvey: Button
    private lateinit var buttonNextSurvey: Button
    private lateinit var question: TextView


    //list of answers. they will have different types, but similar names
    //Frage 1 View
    private lateinit var edit1: EditText
    private var userAge: Int = 0                                                //for .json

    //Frage2 View
    private lateinit var radioGroupQ2: RadioGroup
    private lateinit var radioButtonYesQ2: RadioButton
    private lateinit var radioButtonNoQ2: RadioButton
    private lateinit var radioButtonDontCareQ2: RadioButton
    var childrenContent: Boolean? = null                                        //for .json

    //Frage3 View
    private lateinit var seriesCheckboxQ3: CheckBox
    private lateinit var moviesCheckboxQ3: CheckBox
    private lateinit var bothCheckboxQ3: CheckBox

    //Frage4 View
    private lateinit var radioGroupQ4: RadioGroup
    private lateinit var radioButtonLiveActionQ4: RadioButton
    private lateinit var radioButtonAnimationQ4: RadioButton
    private lateinit var radioButtonDontCareQ4: RadioButton
    var liveAction_over_animated: Boolean? = null                                        //for .json
    var animated_over_liveAction: Boolean? = null                                        //for .json

    //Frage5 View
    private lateinit var Q5Checkbox_movies: CheckBox
    private lateinit var Q5Checkbox_series: CheckBox
    private lateinit var Q5Checkbox_documentury: CheckBox
    private lateinit var Q5Checkbox_news: CheckBox
    private lateinit var Q5Checkbox_show: CheckBox
    private lateinit var Q5Checkbox_all: CheckBox

    //Frage6 View
    private lateinit var radioGroupQ6: RadioGroup
    private lateinit var radioButtonShortQ6: RadioButton
    private lateinit var radioButtonMediumQ6: RadioButton
    private lateinit var radioButtonLongQ6: RadioButton
    private lateinit var radioButtonNeutralQ6: RadioButton
    var episodeLengthShort: Boolean? = null                                        //for .json
    var episodeLengthMedium: Boolean? = null                                        //for .json
    var episodeLengthLarge: Boolean? = null                                        //for .json


    //Frage7 View
    private lateinit var radioGroupQ7: RadioGroup
    private lateinit var radioButtonShortQ7: RadioButton
    private lateinit var radioButtonMediumQ7: RadioButton
    private lateinit var radioButtonLongQ7: RadioButton
    private lateinit var radioButtonNeutralQ7: RadioButton
    var movieLengthShort: Boolean? = null                                        //for .json
    var movieLengthMedium: Boolean? = null                                        //for .json
    var movieLengthLarge: Boolean? = null                                        //for .json                                      //for .json

    //Frage8 View
    private lateinit var radioGroupQ8: RadioGroup
    private lateinit var radioButtonYesQ8: RadioButton
    private lateinit var radioButtonNoQ8: RadioButton
    private lateinit var radioButtonDontCareQ8: RadioButton
    var airing: Boolean? = null                                        //for .json

    //Frage9 View
    private lateinit var Q9CheckboxPublisher_ARD: CheckBox
    private lateinit var Q9CheckboxPublisher_BR: CheckBox
    private lateinit var Q9CheckboxPublisher_HR_Fernsehen: CheckBox
    private lateinit var Q9CheckboxPublisher_Arte: CheckBox
    private lateinit var Q9CheckboxPublisher_Radio_Bremen: CheckBox
    private lateinit var Q9CheckboxPublisher_Das_Erste: CheckBox
    private lateinit var Q9CheckboxPublisher_Kika: CheckBox
    private lateinit var Q9CheckboxPublisher_Tagesschau24: CheckBox
    private lateinit var Q9CheckboxPublisher_Sr: CheckBox
    private lateinit var Q9CheckboxPublisher_Ndr: CheckBox
    private lateinit var Q9CheckboxPublisher_Mdr: CheckBox
    private lateinit var Q9CheckboxPublisher_Swr: CheckBox
    private lateinit var Q9CheckboxPublisher_Rbb_Fernsehen: CheckBox
    private lateinit var Q9CheckboxPublisher_Wdr: CheckBox
    private lateinit var Q9CheckboxPublisher_Funk: CheckBox
    private lateinit var Q9CheckboxPublisher_Phoenix: CheckBox
    private lateinit var Q9CheckboxPublisher_One: CheckBox
    private lateinit var Q9CheckboxPublisher_3sat: CheckBox
    private lateinit var Q9CheckboxPublisher_All: CheckBox


    //Frage10 View
    private lateinit var radioGroupQ10: RadioGroup
    private lateinit var radioButtonYesQ10: RadioButton
    private lateinit var radioButtonNoQ10: RadioButton
    private lateinit var radioButtonDontCareQ10: RadioButton
    var globalshows: Boolean? = null                                        //for .json

    //Frage11 View
    private lateinit var radioGroupQ11: RadioGroup
    private lateinit var radioButtonYesQ11: RadioButton
    private lateinit var radioButtonNoQ11: RadioButton
    private lateinit var radioButtonDontCareQ11: RadioButton
    var subtitles: Boolean? = null                                          //for .json

    //Frage12 View
    private lateinit var radioGroupQ12: RadioGroup
    private lateinit var radioButtonYesQ12: RadioButton
    private lateinit var radioButtonNoQ12: RadioButton
    private lateinit var radioButtonDontCareQ12: RadioButton
    var sign_language: Boolean? = null                                       //for .json

    //Frage13 View
    private lateinit var radioGroupQ13: RadioGroup
    private lateinit var radioButtonYesQ13: RadioButton
    private lateinit var radioButtonNoQ13: RadioButton
    private lateinit var radioButtonDontCareQ13: RadioButton
    var futureAvailability: Boolean? = null                                  //for .json

    //Frage14 View
    private lateinit var radioGroupQ14: RadioGroup
    private lateinit var radioButtonYesQ14: RadioButton
    private lateinit var radioButtonNoQ14: RadioButton
    private lateinit var radioButtonDontCareQ14: RadioButton
    var pastAvailability: Boolean? = null                                 //for .json

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)



        buttonBackSurvey = findViewById(R.id.button_back_survey)
        buttonHomeSurvey = findViewById(R.id.button_home_survey)
        buttonNextSurvey = findViewById(R.id.button_next_survey)
        question = findViewById(R.id.question)

        //Frage1 views
        edit1 = findViewById(R.id.Q1_editAge)

        //Frage2 views
        radioGroupQ2 = findViewById<RadioGroup>(R.id.Q2_RadioGroup)
        radioButtonYesQ2 = findViewById<RadioButton>(R.id.Q2_YesRadioButton)
        radioButtonNoQ2 = findViewById<RadioButton>(R.id.Q2_NoRadioButton)
        radioButtonDontCareQ2 = findViewById<RadioButton>(R.id.Q2_BothRadioButton)

        //Frage3 views
        seriesCheckboxQ3 = findViewById<CheckBox>(R.id.Q3_SeriesCheckbox)
        moviesCheckboxQ3 = findViewById<CheckBox>(R.id.Q3_MoviesCheckbox)
        bothCheckboxQ3 = findViewById<CheckBox>(R.id.Q3_X_Checkbox)





        //Frage4 views
        radioGroupQ4 = findViewById<RadioGroup>(R.id.Q4_RadioGroup)
        radioButtonLiveActionQ4 = findViewById<RadioButton>(R.id.Q4_LiveActionRadioButton)
        radioButtonAnimationQ4 = findViewById<RadioButton>(R.id.Q4_AnimationRadioButton)
        radioButtonDontCareQ4 = findViewById<RadioButton>(R.id.Q4_BothRadioButton)

        //Frage5 views

        Q5Checkbox_movies = findViewById(R.id.Q5_Category_MovieCheckbox)
        Q5Checkbox_series = findViewById(R.id.Q5_Category_SeriesCheckbox)
        Q5Checkbox_documentury = findViewById(R.id.Q5_Category_DocumentaryCheckbox)
        Q5Checkbox_news = findViewById(R.id.Q5_Category_NewsCheckbox)
        Q5Checkbox_show = findViewById(R.id.Q5_Category_ShowCheckbox)
        Q5Checkbox_all = findViewById(R.id.Q5_Category_AllCheckbox)

        //Frage6 views
        radioGroupQ6 = findViewById(R.id.Q6_RadioGroup)
        radioButtonShortQ6 = findViewById(R.id.Q6_ShortRadioButton)
        radioButtonMediumQ6 = findViewById(R.id.Q6_MediumRadioButton)
        radioButtonLongQ6 = findViewById(R.id.Q6_LongRadioButton)
        radioButtonNeutralQ6 = findViewById(R.id.Q6_AllRadioButton)

        //Frage7 views
        radioGroupQ7 = findViewById(R.id.Q7_RadioGroup)
        radioButtonShortQ7 = findViewById(R.id.Q7_ShortRadioButton)
        radioButtonMediumQ7 = findViewById(R.id.Q7_MediumRadioButton)
        radioButtonLongQ7 = findViewById(R.id.Q7_LongRadioButton)
        radioButtonNeutralQ7 = findViewById(R.id.Q7_AllRadioButton)

        //Frage8 views
        radioGroupQ8 = findViewById<RadioGroup>(R.id.Q8_RadioGroup)
        radioButtonYesQ8 = findViewById<RadioButton>(R.id.Q8_YesRadioButton)
        radioButtonNoQ8 = findViewById<RadioButton>(R.id.Q8_NoRadioButton)
        radioButtonDontCareQ8 = findViewById<RadioButton>(R.id.Q8_BothRadioButton)

        //Frage9 views
        Q9CheckboxPublisher_ARD = findViewById(R.id.Q9_Publisher_ARDCheckbox)
        Q9CheckboxPublisher_BR = findViewById(R.id.Q9_Publisher_Br_Checkbox)
        Q9CheckboxPublisher_HR_Fernsehen = findViewById(R.id.Q9_Publisher_HR_Fernsehen_Checkbox)
        Q9CheckboxPublisher_Arte = findViewById(R.id.Q9_Publisher_Arte_Checkbox)
        Q9CheckboxPublisher_Radio_Bremen = findViewById(R.id.Q9_Publisher_Radio_Bremen_Checkbox)
        Q9CheckboxPublisher_Das_Erste = findViewById(R.id.Q9_Publisher_Das_Erste_Checkbox)
        Q9CheckboxPublisher_Kika  = findViewById(R.id.Q9_Publisher_Kika_Checkbox)
        Q9CheckboxPublisher_Tagesschau24 = findViewById(R.id.Q9_Publisher_Tagesschau24_Checkbox)
        Q9CheckboxPublisher_Sr = findViewById(R.id.Q9_Publisher_Sr_Checkbox)
        Q9CheckboxPublisher_Ndr = findViewById(R.id.Q9_Publisher_Ndr_Checkbox)
        Q9CheckboxPublisher_Mdr  = findViewById(R.id.Q9_Publisher_Mdr_Checkbox)
        Q9CheckboxPublisher_Swr = findViewById(R.id.Q9_Publisher_Swr_Checkbox)
        Q9CheckboxPublisher_Rbb_Fernsehen = findViewById(R.id.Q9_Publisher_Rbb_Fernsehen_Checkbox)
        Q9CheckboxPublisher_Wdr = findViewById(R.id.Q9_Publisher_Wdr_Checkbox)
        Q9CheckboxPublisher_Funk = findViewById(R.id.Q9_Publisher_Funk_Checkbox)
        Q9CheckboxPublisher_Phoenix = findViewById(R.id.Q9_Publisher_Phoenix_Checkbox)
        Q9CheckboxPublisher_One = findViewById(R.id.Q9_Publisher_One_Checkbox)
        Q9CheckboxPublisher_3sat = findViewById(R.id.Q9_Publisher_3sat_Checkbox)
        Q9CheckboxPublisher_All = findViewById(R.id.Q9_Publisher_All_Checkbox)


        //Frage10 views
        radioGroupQ10 = findViewById<RadioGroup>(R.id.Q10_RadioGroup)
        radioButtonYesQ10 = findViewById<RadioButton>(R.id.Q10_YesRadioButton)
        radioButtonNoQ10 = findViewById<RadioButton>(R.id.Q10_NoRadioButton)
        radioButtonDontCareQ10 = findViewById<RadioButton>(R.id.Q10_BothRadioButton)

        //Frage11 views
        radioGroupQ11 = findViewById<RadioGroup>(R.id.Q11_RadioGroup)
        radioButtonYesQ11 = findViewById<RadioButton>(R.id.Q11_YesRadioButton)
        radioButtonNoQ11 = findViewById<RadioButton>(R.id.Q11_NoRadioButton)
        radioButtonDontCareQ11 = findViewById<RadioButton>(R.id.Q11_BothRadioButton)

        //Frage12 views
        radioGroupQ12 = findViewById<RadioGroup>(R.id.Q12_RadioGroup)
        radioButtonYesQ12 = findViewById<RadioButton>(R.id.Q12_YesRadioButton)
        radioButtonNoQ12 = findViewById<RadioButton>(R.id.Q12_NoRadioButton)
        radioButtonDontCareQ12 = findViewById<RadioButton>(R.id.Q12_BothRadioButton)

        //Frage13 views
        radioGroupQ13 = findViewById<RadioGroup>(R.id.Q13_RadioGroup)
        radioButtonYesQ13 = findViewById<RadioButton>(R.id.Q13_YesRadioButton)
        radioButtonNoQ13 = findViewById<RadioButton>(R.id.Q13_NoRadioButton)
        radioButtonDontCareQ13 = findViewById<RadioButton>(R.id.Q13_BothRadioButton)

        //Frage14 views
        radioGroupQ14 = findViewById<RadioGroup>(R.id.Q14_RadioGroup)
        radioButtonYesQ14 = findViewById<RadioButton>(R.id.Q14_YesRadioButton)
        radioButtonNoQ14 = findViewById<RadioButton>(R.id.Q14_NoRadioButton)
        radioButtonDontCareQ14 = findViewById<RadioButton>(R.id.Q14_BothRadioButton)



        buttonNextSurvey.isEnabled = false // Button standardmäßig deaktiviert


        //####Fragen checks####
        //Frage 1
        edit1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Vor dem Ändern des Texts
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Während der Änderung des Texts
            }

            override fun afterTextChanged(s: Editable?) {
                // Nachdem der Text geändert wurde
                val text = s.toString().trim() // Den eingegebenen Text erhalten und Leerzeichen entfernen
                buttonNextSurvey.isEnabled = text.isNotEmpty()

            }
        })

        //Frage 2
        radioGroupQ2.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 3  !!!!! NOT READY YET !!!!!
        seriesCheckboxQ3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                StoreVariable.store= "series"
            }
            updateButtonState()
        }

        moviesCheckboxQ3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                StoreVariable.store= "movies"

            }
            updateButtonState()
        }

        bothCheckboxQ3.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        //Frage 4
        radioGroupQ4.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 5
        Q5Checkbox_movies.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q5Checkbox_series.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q5Checkbox_documentury.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q5Checkbox_news.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q5Checkbox_show.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q5Checkbox_all.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        //Frage 6
        radioGroupQ6.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 7
        radioGroupQ7.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 8
        radioGroupQ8.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }


        //Frage 9
        Q9CheckboxPublisher_ARD.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_BR.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_HR_Fernsehen.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Arte.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Radio_Bremen.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Das_Erste.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Kika.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Tagesschau24.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Sr.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Ndr.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Mdr.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Swr.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Rbb_Fernsehen.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Wdr.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Funk.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_Phoenix.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_One.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_3sat.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }

        Q9CheckboxPublisher_All.setOnCheckedChangeListener { buttonView, isChecked ->
            updateButtonState()
        }



        //Frage 10
        radioGroupQ10.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 11
        radioGroupQ11.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 12
        radioGroupQ12.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 13
        radioGroupQ13.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //Frage 14
        radioGroupQ14.setOnCheckedChangeListener { group, checkedId ->
            buttonNextSurvey.isEnabled = checkedId != -1
        }

        //I won't understand this code below if I look at this in a year
        //####Next Questions checks####
        buttonNextSurvey.setOnClickListener {
            if (counter == 1) {
                userAge = edit1.text.toString().toInt()
                edit1.visibility = View.GONE
                if (userAge >= 10) {
                    question.setText(R.string.Q2_young_audience)
                    radioGroupQ2.visibility = View.VISIBLE
                    buttonNextSurvey.isEnabled = false
                    counter++
                }
                else {
                    question.setText(R.string.Q3_genres)
                    seriesCheckboxQ3.visibility = View.VISIBLE
                    moviesCheckboxQ3.visibility = View.VISIBLE
                    bothCheckboxQ3.visibility = View.VISIBLE
                    counter += 2
                    buttonNextSurvey.isEnabled = false
                }


            }
            else if (counter == 2 ) {

                //Functionality
                if (radioButtonYesQ2.isChecked == true) {
                    childrenContent = true
                }

                if (radioButtonNoQ2.isChecked == true) {
                    childrenContent = false
                }

                if (radioButtonDontCareQ2.isChecked == true) {
                    childrenContent = null
                }


                radioGroupQ2.visibility = View.GONE
                seriesCheckboxQ3.visibility = View.VISIBLE
                moviesCheckboxQ3.visibility = View.VISIBLE
                bothCheckboxQ3.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q3_genres)
            }
            else if (counter == 3) {

                seriesCheckboxQ3.visibility = View.GONE
                moviesCheckboxQ3.visibility = View.GONE
                bothCheckboxQ3.visibility = View.GONE
                radioGroupQ4.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q4_animation)
            }
            else if (counter == 4) {

                //Functionality
                if (radioButtonLiveActionQ4.isChecked == true) {
                    liveAction_over_animated = true
                    animated_over_liveAction = false
                }

                if (radioButtonAnimationQ4.isChecked == true) {
                    liveAction_over_animated = false
                    animated_over_liveAction = true
                }

                if (radioButtonDontCareQ4.isChecked == true) {
                    liveAction_over_animated = true
                    animated_over_liveAction = true
                }

                radioGroupQ4.visibility = View.GONE
                Q5Checkbox_series.visibility = View.VISIBLE
                Q5Checkbox_movies.visibility = View.VISIBLE
                Q5Checkbox_documentury.visibility = View.VISIBLE
                Q5Checkbox_news.visibility = View.VISIBLE
                Q5Checkbox_show.visibility = View.VISIBLE
                Q5Checkbox_all.visibility = View.VISIBLE


                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q5_Content)
            }
            else if (counter == 5) {

                Q5Checkbox_series.visibility = View.GONE
                Q5Checkbox_movies.visibility = View.GONE
                Q5Checkbox_documentury.visibility = View.GONE
                Q5Checkbox_news.visibility = View.GONE
                Q5Checkbox_show.visibility = View.GONE
                Q5Checkbox_all.visibility = View.GONE
                radioGroupQ6.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q6_episode_length)
            }
            else if (counter == 6) {

                //Functionality
                if (radioButtonShortQ6.isChecked == true) {
                    episodeLengthShort = true
                    episodeLengthMedium = false
                    episodeLengthLarge = false
                }

                if (radioButtonMediumQ6.isChecked == true) {
                    episodeLengthShort = false
                    episodeLengthMedium = true
                    episodeLengthLarge = false
                }

                if (radioButtonLongQ6.isChecked == true) {
                    episodeLengthShort = false
                    episodeLengthMedium = false
                    episodeLengthLarge = true
                }

                if (radioButtonNeutralQ6 .isChecked == true) {
                    episodeLengthShort = true
                    episodeLengthMedium = true
                    episodeLengthLarge = true
                }

                radioGroupQ6.visibility = View.GONE
                radioGroupQ7.visibility = View.VISIBLE
                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q7_movie_length)
            }
            else if (counter == 7) {

                //Functionality
                if (radioButtonShortQ7.isChecked == true) {
                    movieLengthShort = true
                    movieLengthMedium = false
                    movieLengthLarge = false
                }

                if (radioButtonMediumQ7.isChecked == true) {
                    movieLengthShort = false
                    movieLengthMedium = true
                    movieLengthLarge = false
                }

                if (radioButtonLongQ7.isChecked == true) {
                    movieLengthShort = false
                    movieLengthMedium = false
                    movieLengthLarge = true
                }

                if (radioButtonNeutralQ7 .isChecked == true) {
                    movieLengthShort = true
                    movieLengthMedium = true
                    movieLengthLarge = true
                }

                radioGroupQ7.visibility = View.GONE
                radioGroupQ8.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q8_new_releases)
            }
            else if (counter == 8) {

                radioGroupQ8.visibility = View.GONE
                Q9CheckboxPublisher_ARD.visibility = View.VISIBLE
                Q9CheckboxPublisher_BR.visibility = View.VISIBLE
                Q9CheckboxPublisher_HR_Fernsehen.visibility = View.VISIBLE
                Q9CheckboxPublisher_Arte.visibility = View.VISIBLE
                Q9CheckboxPublisher_Radio_Bremen.visibility = View.VISIBLE
                Q9CheckboxPublisher_Das_Erste.visibility = View.VISIBLE
                Q9CheckboxPublisher_Kika.visibility = View.VISIBLE
                Q9CheckboxPublisher_Tagesschau24.visibility = View.VISIBLE
                Q9CheckboxPublisher_Sr.visibility = View.VISIBLE
                Q9CheckboxPublisher_Ndr.visibility = View.VISIBLE
                Q9CheckboxPublisher_Mdr.visibility = View.VISIBLE
                Q9CheckboxPublisher_Swr.visibility = View.VISIBLE
                Q9CheckboxPublisher_Rbb_Fernsehen.visibility = View.VISIBLE
                Q9CheckboxPublisher_Wdr.visibility = View.VISIBLE
                Q9CheckboxPublisher_Funk.visibility = View.VISIBLE
                Q9CheckboxPublisher_Phoenix.visibility = View.VISIBLE
                Q9CheckboxPublisher_One.visibility = View.VISIBLE
                Q9CheckboxPublisher_3sat.visibility = View.VISIBLE
                Q9CheckboxPublisher_All.visibility = View.VISIBLE


                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q9_publisher)
            }
            else if (counter == 9) {

                Q9CheckboxPublisher_ARD.visibility = View.GONE
                Q9CheckboxPublisher_BR.visibility = View.GONE
                Q9CheckboxPublisher_HR_Fernsehen.visibility = View.GONE
                Q9CheckboxPublisher_Arte.visibility = View.GONE
                Q9CheckboxPublisher_Radio_Bremen.visibility = View.GONE
                Q9CheckboxPublisher_Das_Erste.visibility = View.GONE
                Q9CheckboxPublisher_Kika.visibility = View.GONE
                Q9CheckboxPublisher_Tagesschau24.visibility = View.GONE
                Q9CheckboxPublisher_Sr.visibility = View.GONE
                Q9CheckboxPublisher_Ndr.visibility = View.GONE
                Q9CheckboxPublisher_Mdr.visibility = View.GONE
                Q9CheckboxPublisher_Swr.visibility = View.GONE
                Q9CheckboxPublisher_Rbb_Fernsehen.visibility = View.GONE
                Q9CheckboxPublisher_Wdr.visibility = View.GONE
                Q9CheckboxPublisher_Funk.visibility = View.GONE
                Q9CheckboxPublisher_Phoenix.visibility = View.GONE
                Q9CheckboxPublisher_One.visibility = View.GONE
                Q9CheckboxPublisher_3sat.visibility = View.GONE
                Q9CheckboxPublisher_All.visibility = View.GONE

                radioGroupQ10.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q10_geo_availability)
            }
            else if (counter == 10) {

                radioGroupQ10.visibility = View.GONE
                radioGroupQ11.visibility = View.VISIBLE
                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q11_subtitles)
            }
            else if (counter == 11) {

                radioGroupQ11.visibility = View.GONE
                radioGroupQ12.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q12_sign_language)
            }
            else if (counter == 12) {

                radioGroupQ12.visibility = View.GONE
                radioGroupQ13.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q13_future_available)
            }
            else if (counter == 13) {

                radioGroupQ13.visibility = View.GONE
                radioGroupQ14.visibility = View.VISIBLE

                //always the same
                counter++
                buttonNextSurvey.isEnabled = false
                question.setText(R.string.Q14_not_available)
            }
            else if (counter <= 14) {

                val intent = Intent(this, ResultsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()

            }
            else
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }

        }


        //this needs to change!!
        buttonBackSurvey.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        buttonHomeSurvey.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }


    }




    fun updateButtonState() {

        //Für Frage 3
        val isChecked1 = seriesCheckboxQ3.isChecked
        val isChecked2 = moviesCheckboxQ3.isChecked
        val isChecked3 = bothCheckboxQ3.isChecked

        //Für Frage 5
        val isChecked4 = Q5Checkbox_movies.isChecked
        val isChecked5 = Q5Checkbox_series.isChecked
        val isChecked6 = Q5Checkbox_documentury.isChecked
        val isChecked7 = Q5Checkbox_news.isChecked
        val isChecked8 = Q5Checkbox_show.isChecked
        val isChecked9 = Q5Checkbox_all.isChecked

        //Für Frage 9
        val isChecked10 = Q9CheckboxPublisher_ARD.isChecked
        val isChecked11 = Q9CheckboxPublisher_BR.isChecked
        val isChecked12 = Q9CheckboxPublisher_HR_Fernsehen.isChecked
        val isChecked13 = Q9CheckboxPublisher_Arte.isChecked
        val isChecked14 = Q9CheckboxPublisher_Radio_Bremen.isChecked
        val isChecked15 = Q9CheckboxPublisher_Das_Erste.isChecked
        val isChecked16 = Q9CheckboxPublisher_Kika.isChecked
        val isChecked17 = Q9CheckboxPublisher_Tagesschau24.isChecked
        val isChecked18 = Q9CheckboxPublisher_Sr.isChecked
        val isChecked19 = Q9CheckboxPublisher_Ndr.isChecked
        val isChecked20 = Q9CheckboxPublisher_Mdr.isChecked
        val isChecked21 = Q9CheckboxPublisher_Swr.isChecked
        val isChecked22 = Q9CheckboxPublisher_Rbb_Fernsehen.isChecked
        val isChecked23 = Q9CheckboxPublisher_Wdr.isChecked
        val isChecked24 = Q9CheckboxPublisher_Funk.isChecked
        val isChecked25 = Q9CheckboxPublisher_Phoenix.isChecked
        val isChecked26 = Q9CheckboxPublisher_One.isChecked
        val isChecked27 = Q9CheckboxPublisher_3sat.isChecked
        val isChecked28 = Q9CheckboxPublisher_All.isChecked


        buttonNextSurvey.isEnabled =    isChecked1 || isChecked2 || isChecked3 ||
                                        isChecked4 || isChecked5 || isChecked6 ||
                                        isChecked7 || isChecked8 || isChecked9 ||
                                        isChecked10 || isChecked11 || isChecked12 ||
                                        isChecked13 || isChecked14 || isChecked15 ||
                                        isChecked16 || isChecked17 || isChecked18 ||
                                        isChecked19 || isChecked20 || isChecked21 ||
                                        isChecked22 || isChecked23 || isChecked24 ||
                                        isChecked25 || isChecked26 || isChecked27 ||
                                        isChecked28
    }
}
