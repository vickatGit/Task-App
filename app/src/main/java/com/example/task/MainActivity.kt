package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var minuteHandle:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        minuteHandle=findViewById(R.id.minute_hand);
        var animation:Animation=AnimationUtils.loadAnimation(this,R.anim.clock_hand_anim);
        minuteHandle.startAnimation(animation)
    }
}