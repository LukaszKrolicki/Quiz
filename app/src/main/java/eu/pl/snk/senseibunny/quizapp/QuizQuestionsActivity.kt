package eu.pl.snk.senseibunny.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{

    private var mUserName: String?=null

    private var mCurrentPosition: Int = 1
    private var questionList: ArrayList<Question>?=null
    private var mSelected: Int =0;
    private var mCorrectAnswers: Int =0;

    private var progressBar: ProgressBar?=null;
    private var tvProgress: TextView?=null;
    private var tvQuestion: TextView?=null;
    private var ivImage: ImageView?=null;

    private var tvOption1: TextView?=null;
    private var tvOption2: TextView?=null;
    private var tvOption3: TextView?=null;
    private var tvOption4: TextView?=null;

    private var btnSubmit : Button?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions2)
        Log.i("text", Constants.USER_NAME)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progress_bar)
        tvProgress=findViewById(R.id.progress_text)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        tvOption1=findViewById(R.id.opt1)
        tvOption2=findViewById(R.id.opt2)
        tvOption3=findViewById(R.id.opt3)
        tvOption4=findViewById(R.id.opt4)
        btnSubmit=findViewById(R.id.submit)
        questionList = Constants.getQuestion()

        tvOption1?.setOnClickListener(this);
        tvOption2?.setOnClickListener(this);
        tvOption3?.setOnClickListener(this);
        tvOption4?.setOnClickListener(this);
        btnSubmit?.setOnClickListener(this);

        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {


        val question: Question = questionList!![mCurrentPosition-1]

        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour
        ivImage?.setImageResource(question.image)

        if(mCurrentPosition==questionList!!.size){
            btnSubmit?.text= "Zakończ"
        }
        else{
            btnSubmit?.text="Następne pytanie"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it);
        }
        tvOption2?.let{
            options.add(1,it);
        }
        tvOption3?.let{
            options.add(2,it);
        }
        tvOption4?.let{
            options.add(3,it);
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.default_border
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelected = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)

        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.opt1 ->{
                tvOption1?.let{
                    selectedOptionView(it, 1)
                }
            }

            R.id.opt2 ->{
                tvOption2?.let{
                    selectedOptionView(it, 2)
                }
            }

            R.id.opt3 ->{
                tvOption3?.let{
                    selectedOptionView(it, 3)
                }
            }

            R.id.opt4 ->{
                tvOption4?.let{
                    selectedOptionView(it, 4)
                }
            }
            R.id.submit->{
                if(mSelected==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <=questionList!!.size ->{
                            defaultOptionsView()
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = questionList?.get(mCurrentPosition-1)
                    Log.i("Correct", "${question!!.correctAnswer}")
                    if(question!!.correctAnswer != mSelected){
                        answerView(mSelected, R.drawable.wrong_border)
                    }
                    else{
                        mCorrectAnswers++;
                    }

                    answerView(question.correctAnswer, R.drawable.correct_border)

                    if(mCurrentPosition==questionList?.size){
                        btnSubmit?.text="Zakończ"
                    }
                    else{
                        btnSubmit?.text="Następne pytanie"
                    }

                    mSelected=0;
                }
            }
        }
    }

    private fun answerView(answer: Int, drawablesView: Int){
        when(answer){
            1->{
                tvOption1?.background = ContextCompat.getDrawable(
                    this,
                    drawablesView
                )
            }

            2->{
                tvOption2?.background = ContextCompat.getDrawable(
                    this,
                    drawablesView
                )
            }

            3->{
                tvOption3?.background = ContextCompat.getDrawable(
                    this,
                    drawablesView
                )
            }

            4->{
                tvOption4?.background = ContextCompat.getDrawable(
                    this,
                    drawablesView
                )
            }
        }
    }
}