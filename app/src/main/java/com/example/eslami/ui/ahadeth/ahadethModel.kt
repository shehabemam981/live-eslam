package com.example.eslami.ui.ahadeth

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ahadethModel(
    val title:String,
    val content:String
): Parcelable{}
