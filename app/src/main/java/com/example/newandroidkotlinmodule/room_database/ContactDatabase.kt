package com.example.newandroidkotlinmodule.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.newandroidkotlinmodule.room_database.convertors.ContactConvertor

@Database(entities = [Contact::class], version = 2)
@TypeConverters(ContactConvertor :: class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao() : ContactDao

    companion object{

        // database migration

        val migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isActive INT NOT NULL DEFAULT(1)")  // alter table query in android
            }
        }

        @Volatile
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(context: Context) : ContactDatabase{
            if(INSTANCE==null){

                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "ContactDb"
                    ).addMigrations(migration)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}