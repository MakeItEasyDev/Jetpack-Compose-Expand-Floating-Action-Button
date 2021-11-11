package com.jetpack.expandfloatingbutton

import androidx.annotation.DrawableRes

data class MultiFabItem(
    val id: Int,
    @DrawableRes val iconRes: Int,
    val label: String = ""
)
