package com.example.ai_tic_tac_toe

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlin.concurrent.schedule
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome_screen.*
import java.util.*

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)
        startCircleLoadingAnimations();
        goToMainPage();
    }

    private fun goToMainPage() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 4000)
    }


    private fun startCircleLoadingAnimations() {
        bot_loading.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000)
        bot.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    val rotate = RotateAnimation(
                        0f, 360f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    rotate.duration = 9000
                    rotate.repeatCount = Animation.INFINITE
                    bot_loading.startAnimation(rotate)
                    bot_loading.animate().scaleX(0.7f).scaleY(0.7f).setDuration(1000)
                }
            })
    }
}