package com.example.stand_order_system.strage

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.stand_order_system.models.OrderModel



class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertOrder(order: OrderModel): Boolean {
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.OrderEntry.NUMBER, order.number)
        values.put(DBContract.OrderEntry.PLANE_NUM, order.planeNum)
        values.put(DBContract.OrderEntry.SOY_NUM,   order.soyNum)
        values.put(DBContract.OrderEntry.MEN_NUM,   order.menNum)
        values.put(DBContract.OrderEntry.PIZZA_NUM, order.pizzaNum)
        values.put(DBContract.OrderEntry.DEATH_NUM, order.deathNum)
        values.put(DBContract.OrderEntry.HONEY_NUM, order.honeyNum)

        val rowId = db.insert(DBContract.OrderEntry.TABLE_NAME, null, values)

        return true
    }



    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ORDER.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.OrderEntry.TABLE_NAME + " (" +
            DBContract.OrderEntry.NUMBER  + " INTEGER," +
            DBContract.OrderEntry.PLANE_NUM + " INTEGER," +
            DBContract.OrderEntry.SOY_NUM + " INTEGER," +
            DBContract.OrderEntry.MEN_NUM + " INTEGER," +
            DBContract.OrderEntry.PIZZA_NUM + " INTEGER," +
            DBContract.OrderEntry.DEATH_NUM + " INTEGER," +
            DBContract.OrderEntry.HONEY_NUM + " INTEGER)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.OrderEntry.TABLE_NAME
    }
}