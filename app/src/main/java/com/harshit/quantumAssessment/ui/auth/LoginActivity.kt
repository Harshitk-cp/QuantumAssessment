package com.harshit.quantumAssessment.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.harshit.quantumAssessment.R
import com.harshit.quantumAssessment.databinding.ActivityLoginBinding
import com.harshit.quantumAssessment.ui.home.NewsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), AuthListener {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.apply {
            viewmodel = authViewModel
            lifecycleOwner = this@LoginActivity
        }
        authViewModel.authListener = this
    }

    override fun onStarted() {
//        progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
//        progressbar.visibility = View.GONE
        Intent(this, NewsActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    override fun onFailure(message: String) {
//        progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        authViewModel.user?.let {
            Intent(this, NewsActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}