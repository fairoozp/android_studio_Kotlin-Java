package com.example.diary

import android.provider.BaseColumns

object DatabaseContainer {

    class PersonTable : BaseColumns{
        companion object{
            const val TABLE_NAME = "Diary"
            const val ID = "id"
            const val DATA = "data"

        }
    }
}