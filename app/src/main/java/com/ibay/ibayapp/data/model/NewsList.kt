package com.ibay.ibayapp.data.model

data class NewsList(
    val data: List<News> = arrayListOf(),
    val jumlah: Int = 0,
    val status: Int = 0
)
