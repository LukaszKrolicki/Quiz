package eu.pl.snk.senseibunny.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start : Button = findViewById<Button>(R.id.btn_start)
        val et_name: EditText = findViewById(R.id.et_name)

        btn_start.setOnClickListener{
            if(et_name.text.isEmpty()){
                Toast.makeText(this, "Enter your name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java) //going from this activity to another
                intent.putExtra(Constants.USER_NAME, et_name.text.toString()) //it is used to pass data to other class
                startActivity(intent) //it will move us to other screen but not close current screen
                finish() // we cant go back to previous screen
            }

        }
    }
}