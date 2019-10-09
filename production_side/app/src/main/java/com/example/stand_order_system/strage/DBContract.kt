package com.example.stand_order_system.strage

import android.provider.BaseColumns

object DBContract {
    class OrderList : BaseColumns {
        companion object {
            const val TABLE_NAME = "orders"
            const val NUMBER = "number"
            const val PLANE_NUM = "plane_num"
            const val SOY_NUM = "soy_num"
            const val MEN_NUM = "men_num"
            const val PIZZA_NUM = "pizza_num"
            const val DEATH_NUM = "death_num"
            const val HONEY_NUM = "honey_num"
        }
    }
}