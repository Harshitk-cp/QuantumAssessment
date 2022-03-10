package com.harshit.quantumAssessment.ui.home

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.webkit.WebView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.harshit.quantumAssessment.R

import com.harshit.quantumAssessment.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNewsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news)
        binding.apply {
            viewModel = homeViewModel
            lifecycleOwner = this@NewsActivity
        }
        webView = binding.webView

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.statusBarColor = this.resources.getColor(R.color.dark_blue)
        }
    }

    override fun onBackPressed() {
        if (webView.visibility == View.VISIBLE) {
            webView.startAnimation(
                AnimationUtils.loadAnimation(
                    this,
                    android.R.anim.slide_out_right
                )
            )
            webView.visibility = View.INVISIBLE
        } else
            super.onBackPressed()

    }
}