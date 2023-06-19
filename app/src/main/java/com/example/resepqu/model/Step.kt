package com.example.resepqu.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Step(
    val text : String,
    val photo: String
) : Parcelable
