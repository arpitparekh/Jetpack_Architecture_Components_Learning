package com.example.newandroidkotlinmodule.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Contact(
    @ColumnInfo(name = "name")
    var name : String = "",
    @ColumnInfo(name = "phone")
    var phone : String = "",
    @ColumnInfo(name = "date")
    var createdDate : Date,
    @ColumnInfo(name = "isActive")
    var isActive : Int,
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
)