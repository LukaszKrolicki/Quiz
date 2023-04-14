package eu.pl.snk.senseibunny.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions2)

        val questionList=Constants.getQuestion()
        Log.i("QuestionList sie is","${questionList.size}")
    }
}