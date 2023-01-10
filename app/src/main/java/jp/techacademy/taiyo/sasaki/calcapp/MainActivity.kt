package jp.techacademy.taiyo.sasaki.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        timesButton.setOnClickListener(this)
        dividedButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        try {
            //入力された数字をFloat型で代入
            val Number1 = firstNumber.text.toString().toFloat()
            val Number2 = secondNumber.text.toString().toFloat()

            //intentを作成 & 2つの数字をSecondActivityへ
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Number1", Number1)
            intent.putExtra("Number2", Number2)

            //どのボタンが押されたかをSecondActivityへ送る
            when (v.id) {
                R.id.plusButton -> intent.putExtra("function", "+")
                R.id.minusButton -> intent.putExtra("function", "-")
                R.id.timesButton -> intent.putExtra("function", "×")
                R.id.dividedButton -> intent.putExtra("function", "÷")
            }
            startActivity(intent)
        } catch (e: Exception) {
            //editTextに値が入っていない場合、ココが処理される
            Log.d("NullCheck", "nullを検出")
            make(v,"2つの数字を入力してください", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }
}