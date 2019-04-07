package com.tonny.number26.ui.binding

import android.view.View
import androidx.databinding.BindingConversion

object VisibilityBinding {
  @JvmStatic
  @BindingConversion
  fun bindBooleanToVisibility(isVisible: Boolean): Int =
    if (isVisible) View.VISIBLE else View.INVISIBLE
}