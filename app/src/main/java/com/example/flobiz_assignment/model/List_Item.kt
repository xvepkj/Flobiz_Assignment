package com.example.flobiz_assignment.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ListItem(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId: Int)