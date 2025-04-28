package com.example.brainquiz

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Results: AppCompatActivity() {

    // This a a TextView to show the final score of the quiz.
    private lateinit var finalScoreText: TextView
    // This a Button that allows the user to navigate to the review screen.
    private lateinit var reviewButton: Button
    // This is an Array to store all the questions from the quiz, passed down from the Questions Activity.
    private lateinit var allQuestions: Array<String>
    // This is a Boolean array to store the correct answers for each question, passed down from the Questions activity.
    private lateinit var correctAnswers: BooleanArray
    private var totalQuestions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.results)

        // Initializes the finalScoreText TextView by finding its ID in the layout.
        finalScoreText = findViewById(R.id.finalScoreText)
        // Initializes the reviewButton Button by finding its ID in the layout.
        reviewButton = findViewById(R.id.reviewButton)

        // Retrieves the user's score from the Intent passed from the Questions activity.
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)
        allQuestions = intent.getStringArrayExtra("allQuestions") ?: emptyArray()
        correctAnswers = intent.getBooleanArrayExtra("correctAnswers") ?: booleanArrayOf()

        // Sets the text for the finalScoreText TextView to display the user's score
        // and a message to congratulate or encourage them based on their score.
        finalScoreText.text = "Your Score: $score / $totalQuestions\n" + // Use totalQuestions here
                if (score >= 3) "Great job!" else "Keep practicing!"

        // Sets an OnClickListener for the reviewButton. When clicked, it will create a new Intent to navigate to the Review activity.
        reviewButton.setOnClickListener {
            val intent = Intent(this@Results, Review::class.java)
            intent.putExtra("reviewedQuestions", allQuestions)
            intent.putExtra("reviewedAnswers", correctAnswers)
            startActivity(intent)
        }
    }
}