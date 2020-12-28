package com.ibay.ibayapp.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.ibay.ibayapp.R
import com.ibay.ibayapp.data.model.News
import com.ibay.ibayapp.databinding.ItemNewsBinding
import com.ibay.ibayapp.ui.base.BaseAdapter

class NewsAdapter(val context: Context) : BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val nBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.poster).into(nBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}