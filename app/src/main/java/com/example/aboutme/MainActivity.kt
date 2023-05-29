package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName=MyName("GNS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName=myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickName(it)
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view:View){

//        val editText=findViewById<EditText>(R.id.nickName_edit)
//        val nicknameTextView=findViewById<TextView>(R.id.nickName_text)

//        nicknameTextView.text=editText.text
//        editText.visibility=View.GONE
//        view.visibility=View.GONE
//        nicknameTextView.visibility=View.VISIBLE

        binding.apply {
           // nickNameText.text=nickNameEdit.text
            myName?.nickname=nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility=View.GONE
            doneButton.visibility=View.GONE
            nickNameText.visibility=View.VISIBLE
        }
        val keyb=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyb.hideSoftInputFromWindow(view.windowToken,0)
    }
}