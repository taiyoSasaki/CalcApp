package jp.techacademy.taiyo.sasaki.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //入力された値の受け取り
        val Number1 = intent.getFloatExtra("Number1", 0F)
        val Number2 = intent.getFloatExtra("Number2", 0F)
        val function = intent.getStringExtra("function")

        //値の計算
        val answer = when (function) {
            "+" -> Number1+Number2
            "-" -> Number1-Number2
            "×" -> Number1*Number2
            "÷" -> Number1/Number2
            else -> "Error"
        }

        //画面に表示
        functionLabel.text = "式:　$Number1 $function $Number2"
        answerLabel.text = answer.toString()

    }
}