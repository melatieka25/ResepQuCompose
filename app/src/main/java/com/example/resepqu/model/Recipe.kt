package com.example.resepqu.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val title: String,
    val description: String,
    val photo: String,
    val authorName: String,
    val authorDom: String,
    val authorPhoto: String,
    val createdDate: String,
    val listStep: ArrayList<Step>,
) : Parcelable
