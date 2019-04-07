package com.tonny.number26.ui.base

import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel {
  val disposables = CompositeDisposable()
}