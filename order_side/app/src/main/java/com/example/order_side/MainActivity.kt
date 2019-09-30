package com.example.order_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //合計金額
        var price = findViewById<TextView>(R.id.price)

        //各種ボタン
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

        val reset = findViewById<Button>(R.id.reset)

        //合計金額(変数)
        var priceNum = 0

        //芋の個数
        var planeNum = 0
        var soyNum = 0
        var menNum = 0
        var pizzaNum = 0
        var deathNum = 0
        var honeyNum = 0

        //ボタンが押されたときの動作
        planeA.setOnClickListener{
            planeNum++
            priceNum += 200
            plane.text = planeNum.toString()
            price.text = priceNum.toString()
        }
        planeB.setOnClickListener{
            if(planeNum > 0){
                planeNum--
                priceNum -= 200
                plane.text = planeNum.toString()
                price.text = priceNum.toString()
            }
        }

        soyA.setOnClickListener{
            soyNum++
            priceNum += 200
            soy.text =soyNum.toString()
            price.text =priceNum.toString()
        }
        soyB.setOnClickListener{
            if(soyNum > 0) {
                soyNum--
                priceNum -= 200
                soy.text =soyNum.toString()
                price.text =priceNum.toString()
            }
        }

        menA.setOnClickListener{
            menNum++
            priceNum += 200
            men.text =menNum.toString()
            price.text =priceNum.toString()
        }
        menB.setOnClickListener{
            if(menNum > 0) {
                menNum--
                priceNum -= 200
                men.text =menNum.toString()
                price.text =priceNum.toString()
            }
        }

        deathA.setOnClickListener{
            deathNum++
            priceNum += 250
            death.text =deathNum.toString()
            price.text =priceNum.toString()
        }
        deathB.setOnClickListener{
            if(deathNum > 0){
                deathNum--
                priceNum -= 250
                death.text =deathNum.toString()
                price.text =priceNum.toString()
           }
        }

        pizzaA.setOnClickListener{
            pizzaNum++
            priceNum += 300
            pizza.text =pizzaNum.toString()
            price.text =priceNum.toString()
        }
        pizzaB.setOnClickListener{
            if(pizzaNum > 0) {
                pizzaNum--
                priceNum -= 300
                pizza.text =pizzaNum.toString()
                price.text =priceNum.toString()
            }
        }

        honeyA.setOnClickListener{
            honeyNum++
            priceNum += 200
            honey.text =honeyNum.toString()
            price.text =priceNum.toString()
        }
        honeyB.setOnClickListener{
            if(honeyNum > 0) {
                honeyNum--
                priceNum -= 200
                honey.text = honeyNum.toString()
                price.text = priceNum.toString()
            }
        }

        reset.setOnClickListener{
            priceNum = 0
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
            price.text = priceNum.toString()
        }
    }
}
