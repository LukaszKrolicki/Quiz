package eu.pl.snk.senseibunny.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    private var progressBar: ProgressBar?=null;
    private var tvProgress: TextView?=null;
    private var tvQuestion: TextView?=null;
    private var ivImage: ImageView?=null;

    private var tvOption1: TextView?=null;
    private var tvOption2: TextView?=null;
    private var tvOption3: TextView?=null;
    private var tvOption4: TextView?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions2)


        progressBar=findViewById(R.id.progress_bar)
        tvProgress=findViewById(R.id.progress_text)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        tvOption1=findViewById(R.id.opt1)
        tvOption2=findViewById(R.id.opt2)
        tvOption3=findViewById(R.id.opt3)
        tvOption4=findViewById(R.id.opt4)


        val questionList=Constants.getQuestion()
        Log.i("QuestionList sie is","${questionList.size}")

        for(i in questionList){
            Log.e("Questions", i.question)
        }

        var currentPosition=0
        val question: Question = questionList[currentPosition]
        progressBar?.progress=currentPosition+1
        tvProgress?.text="$currentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text= question.optionOne
        tvOption2?.text= question.optionTwo
        tvOption3?.text= question.optionThree
        tvOption4?.text= question.optionFour
        ivImage?.setImageResource(question.image)
    }
}