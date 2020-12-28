package com.ibay.ibayapp.ui.auth

import android.content.Context
import com.ibay.ibayapp.data.model.ActionState
import com.ibay.ibayapp.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object IbayAppAuth {

    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}