package com.example.feature_toasts

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.core.presentation.UIResourceProvider
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class ToastServiceImpl @Inject constructor(
    val context: Context,
    val uiResourceProvider: UIResourceProvider,
) : ToastService {

    private var activityView: View? = null

    override fun setActivityView(view: View) {
        activityView = view
    }

    override fun detachActivityView() {
        activityView = null
    }

    @SuppressLint("InflateParams")
    override fun showToast(messageId: Int?, icon: Int, message: String?) {
        try {
            val text = message
                ?: messageId?.let { uiResourceProvider.getString(it) }
                ?: "Need error checking"
            val snackbar = activityView?.let {
                Snackbar.make(
                    it,
                    text,
                    Snackbar.LENGTH_SHORT
                )
            }
            val layoutParams = snackbar?.view?.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.bottomMargin = dpToPx(88)
            val custom = LayoutInflater.from(activityView?.context)
                .inflate(R.layout.toast_view, null)
            snackbar.view.setPadding(0, 0, 0, 0)
            (snackbar.view as ViewGroup).removeAllViews()
            (snackbar.view as ViewGroup).addView(custom, 0)
            snackbar.view.layoutParams = layoutParams
            (snackbar.view as ViewGroup).findViewById<TextView>(R.id.tvToast).text = text
            (snackbar.view as ViewGroup).findViewById<ImageView>(R.id.iconToast)
                .setImageResource(icon)
            snackbar.setBackgroundTint(Color.TRANSPARENT)
            snackbar.show()
        } catch (e: Throwable) {
        }
    }

    override fun showErrorToast(message: Throwable) {
        try {
            val errorMessage = R.string.toast_something_went_wrong
            val errorIcon = R.drawable.ic_24_error
            showToast(errorMessage, errorIcon)

        } catch (e: Throwable) {

        }
    }
}

fun dpToPx(dp: Int): Int = (Resources.getSystem().displayMetrics.density * dp).toInt()
