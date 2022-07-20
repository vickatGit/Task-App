package com.example.task

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.task.Fragments.AllListFragments
import com.example.task.Fragments.TaskListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var minuteHandle:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(resources.configuration.orientation!=Configuration.ORIENTATION_LANDSCAPE) {
            minuteHandle = findViewById(R.id.minute_hand);
            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.clock_hand_anim);
            minuteHandle.startAnimation(animation)
        }

        supportFragmentManager.beginTransaction().replace(R.id.framelayout,AllListFragments()).commit()
    }
}
