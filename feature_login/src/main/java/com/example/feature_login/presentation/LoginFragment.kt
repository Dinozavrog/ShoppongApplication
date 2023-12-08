package com.example.feature_login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_login.R

class LoginFragment : Fragment() {


    companion object {
        private const val MODE = "MODE"

        fun newInstance(mode: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(MODE, mode)
                }
            }
    }
}