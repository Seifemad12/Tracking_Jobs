package com.example.trackingjobs.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "jobDesc")
data class UserJobs(@PrimaryKey val id:Int, val Userid:Int, val job:String): Parcelable