package com.example.stand_order_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import com.example.stand_order_system.models.OrderModel
import com.example.stand_order_system.strage.DBHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbtest = findViewById<Button>(R.id.testButton)
        val orderDBHelper = DBHelper(this)

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

        //種類別注文
        val planeNum = findViewById<TextView>(R.id.planeNum)
        val soyNum = findViewById<TextView>(R.id.soyNum)
        val menNum = findViewById<TextView>(R.id.menNum)
        val pizzaNum = findViewById<TextView>(R.id.pizzaNum)
        val deathNum = findViewById<TextView>(R.id.deathNum)
        val honeyNum = findViewById<TextView>(R.id.honeyNum)


        val nowWait = findViewById<TextView>(R.id.nowWaitNum)
        nowWait.text = (orderDBHelper.getNumOrder() - 6).toString()





        /* 関数群 */
        //注文の内容をセット
        fun setOrder(number: Int, order: List<Int>){
            when (number) {
                1 -> {
                    listOf<TextView>(wait0num, wait0A, wait0B, wait0C, wait0D, wait0E, wait0F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
                2 -> {
                    listOf<TextView>(wait1num, wait1A, wait1B, wait1C, wait1D, wait1E, wait1F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
                3 -> {
                    listOf<TextView>(wait2num, wait2A, wait2B, wait2C, wait2D, wait2E, wait2F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
                4 -> {
                    listOf<TextView>(wait3num, wait3A, wait3B, wait3C, wait3D, wait3E, wait3F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
                5 -> {
                    listOf<TextView>(wait4num, wait4A, wait4B, wait4C, wait4D, wait4E, wait4F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
                6 -> {
                    listOf<TextView>(wait5num, wait5A, wait5B, wait5C, wait5D, wait5E, wait5F).forEachIndexed { index, it -> it.text = order[index].toString() }
                }
            }
        }

        //表示する関数
        fun dspWaits(number: Int) {
            when (number) {
                0 -> {
                    listOf<TextView>(wait0, wait0A, wait0B, wait0C, wait0D, wait0E, wait0F, wait0num).forEach { if(it.text != "0") it.visibility = VISIBLE }
                    wait0del.visibility = VISIBLE
                }
                1 -> {
                    listOf<TextView>(wait1, wait1A, wait1B, wait1C, wait1D, wait1E, wait1F, wait1num).forEach { if(it.text != "0")it.visibility = VISIBLE }
                    wait1del.visibility = VISIBLE
                }
                2 -> {
                    listOf<TextView>(wait2, wait2A, wait2B, wait2C, wait2D, wait2E, wait2F, wait2num).forEach { if(it.text != "0")it.visibility = VISIBLE }
                    wait2del.visibility = VISIBLE
                }
                3 -> {
                    listOf<TextView>(wait3, wait3A, wait3B, wait3C, wait3D, wait3E, wait3F, wait3num).forEach { if(it.text != "0")it.visibility = VISIBLE }
                    wait3del.visibility = VISIBLE
                }
                4 -> {
                    listOf<TextView>(wait4, wait4A, wait4B, wait4C, wait4D, wait4E, wait4F, wait4num).forEach { if(it.text != "0")it.visibility = VISIBLE }
                    wait4del.visibility = VISIBLE
                }
                5 -> {
                    listOf<TextView>(wait5, wait5A, wait5B, wait5C, wait5D, wait5E, wait5F, wait5num).forEach { if(it.text != "0")it.visibility = VISIBLE }
                    wait5del.visibility = VISIBLE
                }
            }
        }

        //非表示にする関数
        fun hidWaits(number: Int) {
            when (number) {
                0 -> {
                    listOf<TextView>(wait0, wait0A, wait0B, wait0C, wait0D, wait0E, wait0F, wait0num).forEach { it.visibility = GONE }
                    wait0del.visibility = GONE
                }
                1 -> {
                    listOf<TextView>(wait1, wait1A, wait1B, wait1C, wait1D, wait1E, wait1F, wait1num).forEach { it.visibility = GONE }
                    wait1del.visibility = GONE
                }
                2 -> {
                    listOf<TextView>(wait2, wait2A, wait2B, wait2C, wait2D, wait2E, wait2F, wait2num).forEach { it.visibility = GONE }
                    wait2del.visibility = GONE
                }
                3 -> {
                    listOf<TextView>(wait3, wait3A, wait3B, wait3C, wait3D, wait3E, wait3F, wait3num).forEach { it.visibility = GONE }
                    wait3del.visibility = GONE
                }
                4 -> {
                    listOf<TextView>(wait4, wait4A, wait4B, wait4C, wait4D, wait4E, wait4F, wait4num).forEach { it.visibility = GONE }
                    wait4del.visibility = GONE
                }
                5 -> {
                    listOf<TextView>(wait5, wait5A, wait5B, wait5C, wait5D, wait5E, wait5F, wait5num).forEach { it.visibility = GONE }
                    wait5del.visibility = GONE
                }
            }
        }

        //種類別のやつを反映
        fun kindsOrder(list: List<Int>){
            listOf<TextView>(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum).forEachIndexed{index, it -> it.text = list[index].toString()}
        }

        //一括で非表示にする関数
        fun hidAll(){
            for(i in 0..(orderDBHelper.getNumOrder()+1))
                hidWaits(i)
        }

        //全非表示後に一括表示する関数
        fun dspOrder(){
            val num = orderDBHelper.getNumOrder()

            hidAll()

            when(num){
                0 -> {}
                in 1..6 -> {
                    for( i in 0..num)
                    dspWaits(i-1) }
                else -> {
                    for( i in 0..6)
                    dspWaits(i-1) }
            }
        }

        //非表示件数の計算をする
        fun getHiddenOrder(){
            val hiddenOrder = orderDBHelper.getNumOrder() - 6

            if(hiddenOrder > 0)
                nowWait.text = hiddenOrder.toString()
            else
                nowWait.text = "0"
        }

        fun returnNum(number: Int): Int {
            when (number) {
                0 -> return Integer.parseInt(wait0num.text.toString())
                1 -> return Integer.parseInt(wait1num.text.toString())
                2 -> return Integer.parseInt(wait2num.text.toString())
                3 -> return Integer.parseInt(wait3num.text.toString())
                4 -> return Integer.parseInt(wait4num.text.toString())
                5 -> return Integer.parseInt(wait5num.text.toString())
            }
            return -1
        }

        fun calNumOrder(default: List<Int>, input: List<Int>, mode: Int): List<Int>{
            var result = mutableListOf<Int>()

            for(i in 0..5){
                if(mode == 1)
                    result[i] = default[i] + input[i]
                else
                    result[i] = default[i] + input[i]
            }
            return result
        }

        /* main */


        //初期画面
        for( i in 0..5)hidWaits(i)
        getHiddenOrder()

        var number = 1
        var nowOrder = orderDBHelper.getNumOrder()  //現在のオーダーの総数

        // データベース登録のテスト
        dbtest.setOnClickListener {
            val plane  = Random.nextInt(5)
            val soy  = Random.nextInt(5)
            val men  = Random.nextInt(5)
            val pizza  = Random.nextInt(5)
            val death  = Random.nextInt(5)
            val honey = Random.nextInt(5)

            val order = OrderModel(number, plane, soy, men, pizza, death, honey)
            orderDBHelper.insertOrder(order)
            nowOrder ++

            var range = if (nowOrder > 6) 5 else nowOrder

            for(i in 1..range)
                setOrder(i, orderDBHelper.getOrder(orderDBHelper.getNum(i-1)))

            dspOrder()
            getHiddenOrder()

            number += 1
        }

        //OKボタンを押した際の挙動
        listOf<Button>(wait0del, wait1del, wait2del, wait3del, wait4del, wait5del).forEachIndexed { index, button ->
            button.setOnClickListener {
                orderDBHelper.deleteOrder(returnNum(index))
                nowOrder --

                var range = if (nowOrder > 7) 6 else nowOrder

                for(i in 1..range)
                    setOrder(i, orderDBHelper.getOrder(orderDBHelper.getNum(i-1)))

                dspOrder()
                getHiddenOrder()
            }
        }
    }
}
