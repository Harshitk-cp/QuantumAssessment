package com.harshit.quantumAssessment.utils

import android.view.View
import android.view.animation.AnimationUtils
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.harshit.quantumAssessment.adapter.ChildAdapter
import com.harshit.quantumAssessment.adapter.ParentAdapter
import com.harshit.quantumAssessment.pojo.entities.Article
import com.harshit.quantumAssessment.pojo.entities.ArticleWrapper
import com.harshit.quantumAssessment.ui.home.HomeViewModel

@BindingAdapter("assignList","assignViewModel", requireAll = true)
fun bindList(recyclerView: RecyclerView, list: List<Article>?, homeViewModel: HomeViewModel) {
    val adapter = getChildAdapter(recyclerView)
    adapter.update(list)
    adapter.homeViewModel = homeViewModel
}

private fun getChildAdapter(recyclerView: RecyclerView): ChildAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is ChildAdapter) {
        recyclerView.adapter as ChildAdapter
    } else {
        val adapter = ChildAdapter()
        recyclerView.adapter = adapter
        adapter
    }
}

@BindingAdapter("assignParentList","assignParentViewModel", requireAll = true)
fun bindParentList(recyclerView: RecyclerView, list: List<ArticleWrapper>?, viewModel: HomeViewModel) {
    val adapter = getParentAdapter(recyclerView)
    adapter.update(list)
    adapter.homeViewModel = viewModel
}

private fun getParentAdapter(recyclerView: RecyclerView): ParentAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is ParentAdapter) {
        recyclerView.adapter as ParentAdapter
    } else {
        val adapter = ParentAdapter()
        recyclerView.adapter = adapter
        adapter
    }
}

@BindingAdapter("setImage")
fun bindImage(imageView: ImageView, url: String?) {
    url?.let {
        Picasso.get().load(it).into(imageView)
    }
}

@BindingAdapter("setDate")
fun bindDate(textView: TextView, date: String?) {
    date?.let {
        textView.text = DateHelper.formatDate(it)
    }
}

@BindingAdapter("openNews")
fun bindNews(webView: WebView, item: Article?){
    item?.let {
        webView.startAnimation(
            AnimationUtils.loadAnimation(
                webView.context,
                android.R.anim.slide_in_left
            )
        )
        webView.settings.javaScriptEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webView.loadUrl(item.url)
        webView.visibility = View.VISIBLE
    }
}