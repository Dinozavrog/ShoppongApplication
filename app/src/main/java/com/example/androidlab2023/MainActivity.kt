package com.example.androidlab2023

import android.os.Bundle
import com.example.androidlab2023.ui.BaseMainActivity

class MainActivity : BaseMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.getUIComponentFactory().create().inject(this)
        super.onCreate(savedInstanceState)
    }
}