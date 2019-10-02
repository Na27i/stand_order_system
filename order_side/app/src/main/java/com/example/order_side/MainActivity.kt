package com.example.order_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //合計金額
        var price = findViewById<TextView>(R.id.price)

        //商品ボタン
        var plane = findViewById<TextView>(R.id.プレーン個数)
        val planeA = findViewById<Button>(R.id.プレーンA)
        val planeB = findViewById<Button>(R.id.プレーンB)
        var soy = findViewById<TextView>(R.id.しょうゆ個数)
        val soyA = findViewById<Button>(R.id.しょうゆA)
        val soyB = findViewById<Button>(R.id.しょうゆB)
        var men = findViewById<TextView>(R.id.明太個数)
        val menA = findViewById<Button>(R.id.明太A)
        val menB = findViewById<Button>(R.id.明太B)
        var pizza = findViewById<TextView>(R.id.ピザ個数)
        val pizzaA = findViewById<Button>(R.id.ピザA)
        val pizzaB = findViewById<Button>(R.id.ピザB)
        var death = findViewById<TextView>(R.id.デスソース個数)
        val deathA = findViewById<Button>(R.id.デスソースA)
        val deathB = findViewById<Button>(R.id.デスソースB)
        var honey = findViewById<TextView>(R.id.はちみつ個数)
        val honeyA = findViewById<Button>(R.id.はちみつA)
        val honeyB = findViewById<Button>(R.id.はちみつB)

        //リセットボタン
        val reset = findViewById<Button>(R.id.reset)

        //芋の個数
        var planeNum = 0
        var soyNum = 0
        var menNum = 0
        var pizzaNum = 0
        var deathNum = 0
        var honeyNum = 0

        //セール状態か否か　1なら通常　-1はセール
        var mode = 1

        fun cal(
            plane: Int,
            soy: Int,
            men: Int,
            pizza: Int,
            death: Int,
            honey: Int,
            mode: Int
        ): Int {
            var result =
                plane * 200 + soy * 200 + men * 200 + pizza * 250 + death * 300 + honey * 200
            var sum = plane + soy + men + pizza + death + honey

            if (sum >= 2)
                result -= 50 * (sum / 3)

            if (mode == -1)
                result -= sum * 50

            return result
        }

        //ボタンが押されたときの動作
        planeA.setOnClickListener {
            planeNum++
            plane.text = planeNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        planeB.setOnClickListener {
            if (planeNum > 0) {
                planeNum--
                plane.text = planeNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        soyA.setOnClickListener {
            soyNum++
            soy.text = soyNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        soyB.setOnClickListener {
            if (soyNum > 0) {
                soyNum--
                soy.text = soyNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        menA.setOnClickListener {
            menNum++
            men.text = menNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        menB.setOnClickListener {
            if (menNum > 0) {
                menNum--
                men.text = menNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        deathA.setOnClickListener {
            deathNum++
            death.text = deathNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        deathB.setOnClickListener {
            if (deathNum > 0) {
                deathNum--
                death.text = deathNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        pizzaA.setOnClickListener {
            pizzaNum++
            pizza.text = pizzaNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        pizzaB.setOnClickListener {
            if (pizzaNum > 0) {
                pizzaNum--
                pizza.text = pizzaNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        honeyA.setOnClickListener {
            honeyNum++
            honey.text = honeyNum.toString()
            price.text =
                cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        honeyB.setOnClickListener {
            if (honeyNum > 0) {
                honeyNum--
                honey.text = honeyNum.toString()
                price.text =
                    cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        reset.setOnClickListener{
            planeNum = 0
            soyNum = 0
            menNum = 0
            pizzaNum = 0
            deathNum = 0
            honeyNum = 0
            plane.text = planeNum.toString()
            soy.text = soyNum.toString()
            men.text = menNum.toString()
            pizza.text = pizzaNum.toString()
            death.text = deathNum.toString()
            honey.text = honeyNum.toString()
            price.text = 0.toString()
        }
    }
}
