package com.example.stand_order_system

import android.provider.BaseColumns

object DBContract {
    class OrderList : BaseColumns {
        companion object {
            const val TABLE_NAME = "orders"
            const val NUMBER = "number"
            const val PLANE_NUM = "num of plane"
            const val SOY_NUM = "num of soy"
            const val MEN_NUM = "num of men"
            const val PIZZA_NUM = "num of pizza"
            const val DEATH_NUM = "num of death"
            const val HONEY_NUM = "num of honey"
        }
    }
}