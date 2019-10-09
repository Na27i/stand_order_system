package com.example.stand_order_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import com.example.stand_order_system.models.OrderModel
import com.example.stand_order_system.strage.DBHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //予約1列目
        val wait0 = findViewById<TextView>(R.id.wait0)
        val wait0A = findViewById<TextView>(R.id.wait0A)
        val wait0B = findViewById<TextView>(R.id.wait0B)
        val wait0C = findViewById<TextView>(R.id.wait0C)
        val wait0D = findViewById<TextView>(R.id.wait0D)
        val wait0E = findViewById<TextView>(R.id.wait0E)
        val wait0F = findViewById<TextView>(R.id.wait0F)
        val wait0num = findViewById<TextView>(R.id.wait0num)
        val wait0del = findViewById<Button>(R.id.wait0del)

        //予約2列目
        val wait1 = findViewById<TextView>(R.id.wait1)
        val wait1A = findViewById<TextView>(R.id.wait1A)
        val wait1B = findViewById<TextView>(R.id.wait1B)
        val wait1C = findViewById<TextView>(R.id.wait1C)
        val wait1D = findViewById<TextView>(R.id.wait1D)
        val wait1E = findViewById<TextView>(R.id.wait1E)
        val wait1F = findViewById<TextView>(R.id.wait1F)
        val wait1num = findViewById<TextView>(R.id.wait1num)
        val wait1del = findViewById<Button>(R.id.wait1del)

        //予約3列目
        val wait2 = findViewById<TextView>(R.id.wait2)
        val wait2A = findViewById<TextView>(R.id.wait2A)
        val wait2B = findViewById<TextView>(R.id.wait2B)
        val wait2C = findViewById<TextView>(R.id.wait2C)
        val wait2D = findViewById<TextView>(R.id.wait2D)
        val wait2E = findViewById<TextView>(R.id.wait2E)
        val wait2F = findViewById<TextView>(R.id.wait2F)
        val wait2num = findViewById<TextView>(R.id.wait2num)
        val wait2del = findViewById<Button>(R.id.wait2del)

        //予約4列目
        val wait3 = findViewById<TextView>(R.id.wait3)
        val wait3A = findViewById<TextView>(R.id.wait3A)
        val wait3B = findViewById<TextView>(R.id.wait3B)
        val wait3C = findViewById<TextView>(R.id.wait3C)
        val wait3D = findViewById<TextView>(R.id.wait3D)
        val wait3E = findViewById<TextView>(R.id.wait3E)
        val wait3F = findViewById<TextView>(R.id.wait3F)
        val wait3num = findViewById<TextView>(R.id.wait3num)
        val wait3del = findViewById<Button>(R.id.wait3del)

        //予約5列目
        val wait4 = findViewById<TextView>(R.id.wait4)
        val wait4A = findViewById<TextView>(R.id.wait4A)
        val wait4B = findViewById<TextView>(R.id.wait4B)
        val wait4C = findViewById<TextView>(R.id.wait4C)
        val wait4D = findViewById<TextView>(R.id.wait4D)
        val wait4E = findViewById<TextView>(R.id.wait4E)
        val wait4F = findViewById<TextView>(R.id.wait4F)
        val wait4num = findViewById<TextView>(R.id.wait4num)
        val wait4del = findViewById<Button>(R.id.wait4del)

        //予約6列目
        val wait5 = findViewById<TextView>(R.id.wait5)
        val wait5A = findViewById<TextView>(R.id.wait5A)
        val wait5B = findViewById<TextView>(R.id.wait5B)
        val wait5C = findViewById<TextView>(R.id.wait5C)
        val wait5D = findViewById<TextView>(R.id.wait5D)
        val wait5E = findViewById<TextView>(R.id.wait5E)
        val wait5F = findViewById<TextView>(R.id.wait5F)
        val wait5num = findViewById<TextView>(R.id.wait5num)
        val wait5del = findViewById<Button>(R.id.wait5del)

        //表示する関数
        fun dspWaits(number: Int) {
            when (number) {
                0 -> {
                    listOf<TextView>(
                        wait0,
                        wait0A,
                        wait0B,
                        wait0C,
                        wait0D,
                        wait0E,
                        wait0F,
                        wait0num
                    ).forEach { it.visibility = VISIBLE }
                    wait0del.visibility = VISIBLE
                }
                1 -> {
                    listOf<TextView>(wait1, wait1A, wait1B, wait1C, wait1D, wait1E, wait1F, wait1num).forEach { it.visibility = VISIBLE }
                    wait1del.visibility = VISIBLE
                }
                2 -> {
                    listOf<TextView>(wait2, wait2A, wait2B, wait2C, wait2D, wait2E, wait2F, wait2num).forEach { it.visibility = VISIBLE }
                    wait2del.visibility = VISIBLE
                }
                3 -> {
                    listOf<TextView>(
                        wait3,
                        wait3A,
                        wait3B,
                        wait3C,
                        wait3D,
                        wait3E,
                        wait3F,
                        wait3num
                    ).forEach { it.visibility = VISIBLE }
                    wait3del.visibility = VISIBLE
                }
                4 -> {
                    listOf<TextView>(
                        wait4,
                        wait4A,
                        wait4B,
                        wait4C,
                        wait4D,
                        wait4E,
                        wait4F,
                        wait4num
                    ).forEach { it.visibility = VISIBLE }
                    wait4del.visibility = VISIBLE
                }
                5 -> {
                    listOf<TextView>(
                        wait5,
                        wait5A,
                        wait5B,
                        wait5C,
                        wait5D,
                        wait5E,
                        wait5F,
                        wait5num
                    ).forEach { it.visibility = VISIBLE }
                    wait5del.visibility = VISIBLE
                }
            }
        }

        //非表示にする関数
        fun hidWaits(number: Int) {
            when (number) {
                0 -> {
                    listOf<TextView>(
                        wait0,
                        wait0A,
                        wait0B,
                        wait0C,
                        wait0D,
                        wait0E,
                        wait0F,
                        wait0num
                    ).forEach { it.visibility = GONE }
                    wait0del.visibility = GONE
                }
                1 -> {
                    listOf<TextView>(
                        wait1,
                        wait1A,
                        wait1B,
                        wait1C,
                        wait1D,
                        wait1E,
                        wait1F,
                        wait1num
                    ).forEach { it.visibility = GONE }
                    wait1del.visibility = GONE
                }
                2 -> {
                    listOf<TextView>(
                        wait2,
                        wait2A,
                        wait2B,
                        wait2C,
                        wait2D,
                        wait2E,
                        wait2F,
                        wait2num
                    ).forEach { it.visibility = GONE }
                    wait2del.visibility = GONE
                }
                3 -> {
                    listOf<TextView>(
                        wait3,
                        wait3A,
                        wait3B,
                        wait3C,
                        wait3D,
                        wait3E,
                        wait3F,
                        wait3num
                    ).forEach { it.visibility = GONE }
                    wait3del.visibility = GONE
                }
                4 -> {
                    listOf<TextView>(
                        wait4,
                        wait4A,
                        wait4B,
                        wait4C,
                        wait4D,
                        wait4E,
                        wait4F,
                        wait4num
                    ).forEach { it.visibility = GONE }
                    wait4del.visibility = GONE
                }
                5 -> {
                    listOf<TextView>(
                        wait5,
                        wait5A,
                        wait5B,
                        wait5C,
                        wait5D,
                        wait5E,
                        wait5F,
                        wait5num
                    ).forEach { it.visibility = GONE }
                    wait5del.visibility = GONE
                }
            }
        }

        //OKボタンを押した際の挙動
        listOf<Button>(
            wait0del,
            wait1del,
            wait2del,
            wait3del,
            wait4del,
            wait5del
        ).forEachIndexed { index, button ->
            button.setOnClickListener {
                hidWaits(index)
            }
        }

        for (index in 0..5)
            dspWaits(index)

        var a = 12345
        var b = 1
        var c = 2
        var d = 3
        var e = 4
        var f = 5
        var g = 6

        // データベース登録のテスト
        val testButton = findViewById<Button>(R.id.testButton)
        val orderDBHelper = DBHelper(this)
        testButton.setOnClickListener {
            val order = OrderModel(a, b, c, d, e, f, g)
            val result = orderDBHelper.insertOrder(order)

            if(result) {
               listOf(a, b, c, d, e, f, g).forEach{
                   it + 1
               }
            }
        }
    }
}
