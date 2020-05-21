package com.example.notepadkotlin.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "noteTable")
data class Note (
    @ColumnInfo(name = "noteTitle")
    var noteTitle: String,

    @ColumnInfo(name = "noteDate")
    var lastUpdated: Date,

    @ColumnInfo(name = "noteText")
    var text: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable