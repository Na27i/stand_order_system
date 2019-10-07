package com.example.order_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton


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

        //ボタン
        val ok = findViewById<Button>(R.id.ok)
        val reset = findViewById<Button>(R.id.cancel)

        //ポップアップに関するところ(金額)
        val flame = findViewById<TextView>(R.id.popup_waku)
        val popupOk = findViewById<Button>(R.id.popup_ok)
        val popupCancel = findViewById<Button>(R.id.popup_cancel)
        val popupFlame = findViewById<TextView>(R.id.popup_price_waku)
        val popupYen = findViewById<TextView>(R.id.popup_yen)
        val popupPrice = findViewById<TextView>(R.id.popup_price)

        var inputPrice = 0
        var outputCharge = 0

        listOf<TextView>(flame, popupOk, popupCancel, popupFlame, popupPrice, popupYen).forEach{
            it.visibility = GONE
        }

        //ポップアップに関するところ(計算)
        val button0 = findViewById<Button>(R.id.zero)
        val button1 = findViewById<Button>(R.id.one)
        val button2 = findViewById<Button>(R.id.two)
        val button3 = findViewById<Button>(R.id.three)
        val button4 = findViewById<Button>(R.id.four)
        val button5 = findViewById<Button>(R.id.five)
        val button6 = findViewById<Button>(R.id.six)
        val button7 = findViewById<Button>(R.id.seven)
        val button8 = findViewById<Button>(R.id.eight)
        val button9 = findViewById<Button>(R.id.nine)
        val button00 = findViewById<Button>(R.id.hundred)
        val just = findViewById<Button>(R.id.just)
        val clear = findViewById<Button>(R.id.clear)

        listOf<Button>(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button00, just, clear).forEach {
            it.visibility = GONE
        }

        //お釣りに関する部分
        val chargeFlame = findViewById<TextView>(R.id.chargeFlame)
        val charge = findViewById<TextView>(R.id.charge)
        val changeOk = findViewById<Button>(R.id.chargeOk)

        listOf<TextView>(chargeFlame, charge).forEach{
            it.visibility = GONE
        }
        changeOk.visibility = GONE

        //芋の個数
        var planeNum = 0
        var soyNum = 0
        var menNum = 0
        var pizzaNum = 0
        var deathNum = 0
        var honeyNum = 0

        //セールに関する部分　1なら通常　-1はセール
        var mode = 0
        val sale: ToggleButton = findViewById(R.id.セールボタン)
        sale.setOnCheckedChangeListener { _, isChecked ->
            mode = if (isChecked) {
                -1
            } else {
                1
            }
        }

        //金額の計算
        fun cal(plane: Int, soy: Int, men: Int, pizza: Int, death: Int, honey: Int, mode: Int): Int {
            var result = plane * 200 + soy * 200 + men * 200 + pizza * 250 + death * 300 + honey * 200
            var sum = plane + soy + men + pizza + death + honey

            if (sum >= 2)
                result -= 50 * (sum / 3)

            if (mode == -1)
                result -= sum * 50

            return result
        }

        //ボタン等の表示切替
        fun invState() = if (flame.visibility == GONE){
            listOf<TextView>(flame, popupOk, popupCancel, popupFlame, popupPrice, popupYen).forEach{
                it.visibility = VISIBLE
            }
            listOf<Button>(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button00, just, clear).forEach {
                it.visibility = VISIBLE
            }
            listOf<Button>(planeA, planeB, soyA, soyB, menA, menB, pizzaA, pizzaB, deathA, deathB, honeyA, honeyB).forEach{
                it.visibility = GONE
            }
        }else{
            listOf<TextView>(flame, popupOk, popupCancel, popupFlame, popupPrice, popupYen).forEach{
                it.visibility = GONE
            }
            listOf<Button>(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button00, just, clear).forEach {
                it.visibility = GONE
            }
            listOf<Button>(planeA, planeB, soyA, soyB, menA, menB, pizzaA, pizzaB, deathA, deathB, honeyA, honeyB).forEach {
                it.visibility = VISIBLE
            }
        }

        //リセット
        fun zeroClear(){
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

        //ポップアップ画面の金額リセット
        fun popupReset(){
            inputPrice = 0
            popupPrice.text = 0.toString()
            outputCharge = 0
            charge.text = 0.toString()
        }

        //ボタンが押されたときの動作
        planeA.setOnClickListener {
            planeNum++
            plane.text = planeNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        planeB.setOnClickListener {
            if (planeNum > 0) {
                planeNum--
                plane.text = planeNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }
        soyA.setOnClickListener {
            soyNum++
            soy.text = soyNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        soyB.setOnClickListener {
            if (soyNum > 0) {
                soyNum--
                soy.text = soyNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }
        menA.setOnClickListener {
            menNum++
            men.text = menNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        menB.setOnClickListener {
            if (menNum > 0) {
                menNum--
                men.text = menNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }
        deathA.setOnClickListener {
            deathNum++
            death.text = deathNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        deathB.setOnClickListener {
            if (deathNum > 0) {
                deathNum--
                death.text = deathNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }
        pizzaA.setOnClickListener {
            pizzaNum++
            pizza.text = pizzaNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        pizzaB.setOnClickListener {
            if (pizzaNum > 0) {
                pizzaNum--
                pizza.text = pizzaNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }
        honeyA.setOnClickListener {
            honeyNum++
            honey.text = honeyNum.toString()
            price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
        }
        honeyB.setOnClickListener {
            if (honeyNum > 0) {
                honeyNum--
                honey.text = honeyNum.toString()
                price.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            }
        }

        //注文画面のResetボタン
        reset.setOnClickListener{
            zeroClear()
        }

        //注文画面のOKボタン
        ok.setOnClickListener{
            invState()
        }

        //ポップアップ画面のCancelボタン
        popupCancel.setOnClickListener{
            popupReset()
            invState()
        }

        //ポップアップ画面のOKボタン
        popupOk.setOnClickListener {
            if(outputCharge > 0){
                listOf<TextView>(flame, popupOk, popupCancel, popupFlame, popupPrice, popupYen).forEach{
                    it.visibility = GONE
                }
                listOf<Button>(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button00, just, clear).forEach {
                    it.visibility = GONE
                }
                listOf<TextView>(chargeFlame, charge).forEach{
                    it.visibility = VISIBLE
                }
                changeOk.visibility = VISIBLE
            }
            else{
                popupReset()
                invState()
                zeroClear()
            }
        }

        //電卓画面のClearボタン
        clear.setOnClickListener {
            popupReset()
        }

        //電卓画面のJustボタン
        just.setOnClickListener {
            inputPrice = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode)
            popupPrice.text = cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode).toString()
            outputCharge = 0
        }

        //電卓画面の数字ボタン
        listOf<Button>(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button00).forEachIndexed{index, button ->
            button.setOnClickListener {
                when(index){
                    0 -> inputPrice *= 10
                    in 1..9 -> inputPrice = (inputPrice * 10) + index
                    10 -> inputPrice *= 100
                }
                outputCharge = inputPrice - cal(planeNum, soyNum, menNum, pizzaNum, deathNum, honeyNum, mode)
                charge.text = outputCharge.toString() + "円"
                popupPrice.text = inputPrice.toString()
            }
        }

        //おつり画面のOKボタン
        changeOk.setOnClickListener {
            listOf<Button>(planeA, planeB, soyA, soyB, menA, menB, pizzaA, pizzaB, deathA, deathB, honeyA, honeyB).forEach {
                it.visibility = VISIBLE
            }
            listOf<TextView>(chargeFlame, charge).forEach{
                it.visibility = GONE
            }
            changeOk.visibility = GONE

            popupReset()
            zeroClear()
        }
    }
}
