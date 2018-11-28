package cz.lebedev.mvapp.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleGone")
fun setVisibility(view: View, value: Boolean?) {
view.visibility = if (value!!) View.VISIBLE else View.GONE
}


