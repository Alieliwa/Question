package com.example.question

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import java.lang.Exception

class Font : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.front)
    }
    fun goto(v : View){
        var i = Intent(this,Second::class.java)
        startActivity(i)
    }
    fun rate (v: View){
      try {
          var uri  =   Uri.parse("market://details?id $packageName")
          var gotomarket = Intent(Intent.ACTION_VIEW)
          gotomarket.data = uri
          startActivity(gotomarket)
      }catch (ex : Exception){
          var uri  =   Uri.parse("http://play.google.com/store/apps/details?id $packageName")
          var gotomarket = Intent(Intent.ACTION_VIEW)
          gotomarket.data = uri
          startActivity(gotomarket)
      }

    }
}