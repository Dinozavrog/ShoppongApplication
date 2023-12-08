package com.example.core.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class CustomViewModel : ViewModel() {
    protected val _throwable = SingleLiveEvent<Throwable>()
    val throwable: LiveData<Throwable> = _throwable

    protected val errorHandler = CoroutineExceptionHandler { _, throwable ->
        _throwable.value = throwable
    }
}