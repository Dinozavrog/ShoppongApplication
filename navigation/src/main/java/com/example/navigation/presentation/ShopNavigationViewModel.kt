package com.example.navigation.presentation

import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.SingleLiveEvent
import com.example.navigation.R
import com.example.navigation.domain.MainRouter
import javax.inject.Inject

class ShopNavigationViewModel @Inject constructor(
    private val router: MainRouter,
): ViewModel() {

    private val _fromBackStackOpenedTabId = SingleLiveEvent<Int>()
    val fromBackStackOpenedTabId: LiveData<Int> = _fromBackStackOpenedTabId
    private val tabsBackStack = mutableListOf<Int>()

    init {
        tabsBackStack.add(FIRST_TAB_ID)
    }

    fun popBackStack(): Boolean {
        if (tabsBackStack.isNotEmpty() && !tabsBackStack.all { it == FIRST_TAB_ID }) {
            val tabId = if (tabsBackStack.size > 1) {
                tabsBackStack[tabsBackStack.size - 2]
            } else {
                FIRST_TAB_ID
            }
            tabsBackStack.removeLast()
            _fromBackStackOpenedTabId.value = tabId
            return true
        }
        return false
    }

    fun addToBackStack(@IdRes id: Int) {
        if (id in tabsBackStack) {
            tabsBackStack.remove(id)
        }
        if (id != FIRST_TAB_ID || tabsBackStack.isNotEmpty())
            tabsBackStack.add(id)
    }

    companion object {
        private val FIRST_TAB_ID = R.id.home_navigation
    }
}