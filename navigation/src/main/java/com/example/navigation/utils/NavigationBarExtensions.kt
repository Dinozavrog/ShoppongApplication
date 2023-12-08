package com.example.navigation.utils

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.core.view.forEach
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import java.lang.ref.WeakReference

fun NavigationBarView.setupWithNavController(
    navController: NavController,
    itemClickListener: ((Int) -> Unit),
) {

    this.setOnItemSelectedListener { item ->
        itemClickListener(item.itemId)
        NavigationUI.onNavDestinationSelected(
            item,
            navController
        )
    }
    val weakReference = WeakReference(this)
    navController.addOnDestinationChangedListener(
        object : NavController.OnDestinationChangedListener {
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?,
            ) {
                val view = weakReference.get()
                if (view == null) {
                    navController.removeOnDestinationChangedListener(this)
                    return
                }
                view.menu.forEach { item ->
                    if (destination.matchDestination(item.itemId)) {
                        item.isChecked = true
                    }
                }
            }
        })

}

private fun NavDestination.matchDestination(@IdRes destId: Int): Boolean =
    hierarchy.any { it.id == destId }