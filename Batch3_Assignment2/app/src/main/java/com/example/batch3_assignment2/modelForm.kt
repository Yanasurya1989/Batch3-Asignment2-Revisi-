package com.example.batch3_assignment2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class modelForm (

    var username : String,
    var password : String

) : Parcelable