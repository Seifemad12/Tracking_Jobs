package com.example.trackingjobs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "todoData")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int, val title: String, val body: String
) : Parcelable