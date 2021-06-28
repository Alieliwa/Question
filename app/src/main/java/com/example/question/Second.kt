package com.example.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.*

class Second : AppCompatActivity() {

    lateinit var tv_question:TextView
    lateinit var tv_xx:TextView
    lateinit var tv_answer:TextView
    lateinit var tv_yy:TextView
    lateinit var back : Button
    lateinit var submit : Button
    lateinit var front : Button
    lateinit var voice : Button
    var val_ques : Array<String>? = null
    var val_ans : Array<String>? = null
    var index: Int? = null
    var defualt_text = "press Star * To get Answer"
    var txtspeech : TextToSpeech? =  null
    var res: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_second)

        txtspeech = TextToSpeech(this,object : TextToSpeech.OnInitListener{
            override fun onInit(status: Int) {
               res = txtspeech?.setLanguage(Locale.ENGLISH)!!
            }

        })

        tv_question= findViewById(R.id.tv_question)
        tv_xx= findViewById(R.id.tv_xx)
        tv_yy= findViewById(R.id.tv_yy)
        back =findViewById(R.id.back)
        submit =findViewById(R.id.submit)
        front =findViewById(R.id.submit)
        voice = findViewById(R.id.voice)
        tv_answer= findViewById(R.id.tv_answer)

        index = 0
        val_ques = resources.getStringArray(R.array.ques)
        val_ans = resources.getStringArray(R.array.ans)

        tv_question.text = "${val_ques!![index!!]}"
        tv_answer.text = defualt_text

        tv_xx.text ="${index!! + 1}"
        tv_yy.text = "/${val_ques!!.size}"
    }
    fun show_ansewr(v: View){
        when(v.id){
            R.id.back   -> {
                try {
                    tv_answer.text = defualt_text
                    index = index?.minus(1)
                    tv_question.text = "${val_ques!![index!!]}"

                    tv_xx.text ="${index!! + 1}"
                    tv_yy.text = "/${val_ques!!.size}"
                }catch (ex:Exception){

                    index = val_ques!!.size - 1
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text ="${index!! + 1}"
                    tv_yy.text = "/${val_ques!!.size}"
                }

            }
            R.id.submit -> {
                tv_answer.text = "${val_ans!![index!!]}"
            }
            R.id.front  -> {
                try {
                    tv_answer.text = defualt_text
                    index = index?.plus(1)
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text ="${index!! + 1}"
                    tv_yy.text = "/${val_ques!!.size}"
                }catch (ex:Exception){

                    index = 5 - val_ques!!.size
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text ="${index!! + 1}"
                    tv_yy.text = "/${val_ques!!.size}"
                }

            }
            R.id.voice -> {
                if (res == TextToSpeech.LANG_NOT_SUPPORTED || res == TextToSpeech.LANG_MISSING_DATA){
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
                }else{
                    txtspeech?.speak(tv_question.text as String? ,TextToSpeech.QUEUE_FLUSH,null,null)
                }
            }

        }
    }


}