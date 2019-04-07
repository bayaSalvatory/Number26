package com.tonny.number26.ui.base

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {
    val disposables = CompositeDisposable()

    override fun onStop() {
        super.onStop()
        disposables.clear()
    }
}