package com.ibay.ibayapp.data.repository

import com.ibay.ibayapp.data.model.ActionState
import com.ibay.ibayapp.data.model.News
import com.ibay.ibayapp.data.remote.NewsService
import com.ibay.ibayapp.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>>{
        return try {
            val list = newsService.listNews().await()
            ActionState(list.data)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News>{
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.data.first())
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.data)
        } catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}