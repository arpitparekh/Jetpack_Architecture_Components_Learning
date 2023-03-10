package com.example.newandroidkotlinmodule.room_database.convertors

import androidx.room.TypeConverter
import java.util.*

class ContactConvertor{

    @TypeConverter
    fun fromDateToLong(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long : Long) : Date{
        return Date(long)
    }

}