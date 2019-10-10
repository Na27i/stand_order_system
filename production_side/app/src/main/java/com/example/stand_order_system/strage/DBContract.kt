package com.example.stand_order_system.strage

import android.provider.BaseColumns

object DBContract {

    class OrderEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "orders"
            val NUMBER = "number"
            val PLANE_NUM = "plane"
            val SOY_NUM = "soy"
            val MEN_NUM = "men"
            val PIZZA_NUM = "pizza"
            val DEATH_NUM = "death"
            val HONEY_NUM = "honey"
        }
    }
}