package com.example.stand_order_system.strage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteException
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

    fun deleteOrder(number : Int): Boolean{
        val db = writableDatabase
        db.delete(DBContract.OrderEntry.TABLE_NAME, "number=?", arrayOf(number.toString()))

        return true
    }

    fun getOrder(number: Int): ArrayList<OrderModel> {
        val order = ArrayList<OrderModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.OrderEntry.TABLE_NAME + " WHERE " + DBContract.OrderEntry.NUMBER + "='" + number + "'", null)
        } catch (e: SQLiteException) {
            // if table not yet present, create it
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var plane: Int
        var soy: Int
        var men: Int
        var pizza: Int
        var death: Int
        var honey: Int

        if (cursor!!.moveToFirst()) {
            while (!cursor.isAfterLast) {
                plane = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.PLANE_NUM))
                soy = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.SOY_NUM))
                men = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.MEN_NUM))
                pizza = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.MEN_NUM))
                death = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.MEN_NUM))
                honey = cursor.getInt(cursor.getColumnIndex(DBContract.OrderEntry.MEN_NUM))

                order.add(OrderModel(number, plane, soy, men, pizza, death, honey))
                cursor.moveToNext()
            }
        }
        return order
    }

    fun getNumOrder(): Int{
        val db = writableDatabase
        val select = "select * from " + DBContract.OrderEntry.TABLE_NAME
        val cursor = db.rawQuery(select, null)

        return cursor.count
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