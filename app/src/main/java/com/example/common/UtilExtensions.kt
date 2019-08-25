package com.example.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

const val DEFAULT_ERROR_MESSAGE = "Sorry, something went wrong."

fun Throwable?.getErrorMessage() = this?.message ?: DEFAULT_ERROR_MESSAGE

fun <T : ViewModel> FragmentActivity.obtainViewModel(cls: Class<T>) =
    obtainViewModel(ViewModelFactory.getInstance(application), cls)

fun <T : ViewModel> Fragment.obtainViewModel(cls: Class<T>) =
    activity?.run { obtainViewModel(ViewModelFactory.getInstance(application), cls) }

fun <VM : ViewModel> FragmentActivity.obtainViewModel(factory: ViewModelProvider.Factory, cls: Class<VM>) =
    ViewModelProviders.of(this, factory).get(cls)

fun <T> LifecycleOwner.observeCommand(data: LiveData<T>, action: (T) -> Unit) {
    data.observe(this, Observer(action))
}

fun Context.convertToPx(dp: Float) = dp * resources.displayMetrics.density

fun Context.convertToDp(px: Float) = px / resources.displayMetrics.density