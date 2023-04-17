package eu.pl.snk.senseibunny.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end_scr)

        val tvName: TextView = findViewById(R.id.name)
        val res: TextView = findViewById(R.id.result)
        val btn: Button = findViewById<Button>(R.id.end_btn)

        tvName.text= intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        res.text= "Zdobyłeś $correctAnswers/$totalQuestions punktów"

        btn.setOnClickListener()
        {
           startActivity((Intent(this, MainActivity::class.java)))
        }
    }
}