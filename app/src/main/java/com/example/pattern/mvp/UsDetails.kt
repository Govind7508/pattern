package com.example.pattern.mvp

import com.example.pattern.USData

interface UsDetails {
    fun showLoading()
    fun hideLoading()
    fun showUsers(us: USData)
    fun showError(message: String)
}