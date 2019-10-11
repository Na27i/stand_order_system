package com.example.stand_order_system.strage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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

    // テーブルのN番目の整理番号の値を取得
    fun getNum(number: Int): String {
        val db = writableDatabase
        val select = "SELECT * FROM " + DBContract.OrderEntry.TABLE_NAME
        val cursor = db.rawQuery(select, null)

        var result = "9999"
        cursor.moveToFirst()

        for (i in 0..number) {
            result = cursor.getInt(0).toString()
            if(i != number) cursor.moveToNext() }
        cursor.close()

        return result
    }

    //整理番号から注文状況を取得
    fun getOrder( number : String) : List<Int> {
        val db = writableDatabase
        val select= "SELECT * FROM " + DBContract.OrderEntry.TABLE_NAME
        val cursor = db.rawQuery(select, null)

        cursor.moveToFirst()
        while(cursor.getInt(0).toString() != number) {
            cursor.moveToNext()
        }

        return listOf(
            cursor.getInt(0),
            cursor.getInt(1),
            cursor.getInt(2),
            cursor.getInt(3),
            cursor.getInt(4),
            cursor.getInt(5),
            cursor.getInt(6)
        )
        cursor.close()
    }

    fun deleteOrder(number : Int): Boolean{
        val db = writableDatabase
        db.delete(DBContract.OrderEntry.TABLE_NAME, "number=?", arrayOf(number.toString()))

        return true
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