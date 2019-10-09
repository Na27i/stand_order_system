package com.example.stand_order_system

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.stand_order_system.OrderModel

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    @Throws(SQLiteException::class)
    fun insertOrder(order: OrderModel): Boolean {
        val db = writableDatabase

        val values = ContentValues()
        values.put(DBContract.OrderList.NUMBER, order.NUMBER)
        values.put(DBContract.OrderList.PLANE_NUM, order.PLANE_NUM)
        values.put(DBContract.OrderList.SOY_NUM,   order.SOY_NUM)
        values.put(DBContract.OrderList.MEN_NUM,   order.MEN_NUM)
        values.put(DBContract.OrderList.PIZZA_NUM, order.PIZZA_NUM)
        values.put(DBContract.OrderList.DEATH_NUM, order.DEATH_NUM)
        values.put(DBContract.OrderList.HONEY_NUM, order.HONEY_NUM)

        val rowId = db.insert(DBContract.OrderList.TABLE_NAME, null, values)

        return true
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ALL_ORDERS.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE " +
            DBContract.OrderList.TABLE_NAME + " (" +
            DBContract.OrderList.NUMBER    + " INTEGER," +
            DBContract.OrderList.PLANE_NUM + " INTEGER," +
            DBContract.OrderList.SOY_NUM   + " INTEGER," +
            DBContract.OrderList.MEN_NUM   + " INTEGER," +
            DBContract.OrderList.PIZZA_NUM + " INTEGER," +
            DBContract.OrderList.DEATH_NUM + " INTEGER," +
            DBContract.OrderList.HONEY_NUM + " INTEGER)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.OrderList.TABLE_NAME
    }
}