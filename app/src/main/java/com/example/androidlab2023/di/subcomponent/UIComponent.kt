package com.example.androidlab2023.di.subcomponent

import com.example.androidlab2023.MainActivity
import dagger.Subcomponent

@Subcomponent
interface UIComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UIComponent
    }
}