package com.example.brainquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class Questions: AppCompatActivity() {

    // An Array of questions for the quiz and each question is a string.
    private val questions = arrayOf(
        "An array is a multiple items of the same data type that is stored.",
        "An If statement executes a code when a condition is false.",
        "Kotlin is a programming language that is used to develop a native Android apps.",
        "Boolean is an arithmetic operator.",
        "An Emulator is a Hardware or Software that permits programmes written for one computer to be run on another computer."
    )
    // An Array of correct answers for the quiz, corresponding to the 'questions' array.
    private val answers = arrayOf(
        true,
        false,
        true,
        false,
        true)
    // The first question being displayed which will start at 0.
    private var currentQuestion = 0
    // The users score which will start at 0
    private var score = 0
    // TextView to display the current question.
    private lateinit var questionText: TextView
    // Button for the user to answer "True".
    private lateinit var trueButton: Button
    // Button for the user to answer "False".
    private lateinit var falseButton: Button
    // The TextView will display whether the user's answer were correct or incorrect.
    private lateinit var resultText: TextView
    // A List to store the user's answers.
    private val userAnswers = mutableListOf<Boolean?>() // To store user's answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions)

        // Initializes the TextView to display the question.
        questionText = findViewById(R.id.questionText)
        // Initializes the Button for the "True" answer.
        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        resultText = findViewById(R.id.resultText)
        showQuestion()
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
    }
    private fun showQuestion() {
        if (currentQuestion < questions.size) {
            questionText.text = "${currentQuestion + 1}. ${questions[currentQuestion]}"


        } else {
            // When the Quiz is finished, it will navigate to Results.
            val intent = Intent(this, Results::class.java)
            // Passes the user's score to the 'Results' activity.
            intent.putExtra("score", score)
            intent.putExtra("totalQuestions", questions.size)
            // Pass the questions
            intent.putExtra("allQuestions", questions)
            // Pass the correct answers
            intent.putExtra("correctAnswers", answers)
            startActivity(intent)
            finish()
            resultText.text = ""
        }
    }
    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestion]) {
            resultText.text = " Correct!"
            score++
        } else {
            resultText.text = " Incorrect!"
        }
        currentQuestion++
        showQuestion()
    }
}

