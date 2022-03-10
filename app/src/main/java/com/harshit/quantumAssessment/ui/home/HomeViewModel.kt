package com.harshit.quantumAssessment.ui.home

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harshit.quantumAssessment.pojo.entities.Article
import com.harshit.quantumAssessment.ui.auth.LoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel(){

    init {
        homeRepository.getNewsList()
    }
    val clickedNews = MutableLiveData<Article>()
    val list = homeRepository.newsList

    fun onNewsClick(item: Article){
        clickedNews.postValue(item)
    }

    fun logout(view: View){
        homeRepository.logout()
        view.context.startLoginActivity()
    }

    fun Context.startLoginActivity(): Intent {
        return Intent(this, LoginActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

}