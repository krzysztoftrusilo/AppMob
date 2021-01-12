package com.example.myapp

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var stop: Long = 0
    var start: Long = 0
    var number = 0;
    var textToButton1:String = "0"
    var textToButton2:String = "0"
    var textToButton3:String = "0"
    var textToButton4:String = "0"
    val listOfNumbers = mutableListOf<Int>()
    var buttons = mutableListOf(0,0,0,0)
    var isStarted = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.setOnSeekBarChangeListener(this)
        btnStart.setOnClickListener {
            btn1.text = textToButton1
            btn2.text = textToButton2
            btn3.text = textToButton3
            btn4.text = textToButton4
            isStarted = 1
            start = System.currentTimeMillis();

        }

        btn1.setOnClickListener{
            if(isStarted == 1)
            {
                if(buttons.elementAt(0) == 0)
                {
                    buttons.set(0,1)
                    listOfNumbers.add(btn1.text.toString().toInt());
                    if(listOfNumbers.size == 4)
                    {
                        stop = System.currentTimeMillis()
                        if (listOfNumbers.elementAt(0) <= listOfNumbers.elementAt(1) && listOfNumbers.elementAt(1) <= listOfNumbers.elementAt(2) && listOfNumbers.elementAt(2) <= listOfNumbers.elementAt(3))
                            czasTXT.text = "Udało Ci się!\n Liczby zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop-start)/1000).toString()+ " sekund"
                        else
                            czasTXT.text = "Nie udało się!\n Liczby nie zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop-start)/1000).toString()+ " sekund"
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        buttons.set(0,0)
                        buttons.set(1,0)
                        buttons.set(2,0)
                        buttons.set(3,0)
                        isStarted = 0

                    }
                }

            }


        }

        btn2.setOnClickListener{
            if(isStarted == 1){
                if(buttons.elementAt(1) == 0) {
                    buttons.set(1, 1)
                    listOfNumbers.add(btn2.text.toString().toInt());
                    if (listOfNumbers.size == 4) {
                        stop = System.currentTimeMillis()
                        if (listOfNumbers.elementAt(0) <= listOfNumbers.elementAt(1) && listOfNumbers.elementAt(1) <= listOfNumbers.elementAt(2) && listOfNumbers.elementAt(2) <= listOfNumbers.elementAt(3))
                            czasTXT.text = "Udało Ci się!\n Liczby zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        else
                            czasTXT.text = "Nie udało się!\n Liczby nie zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        buttons.set(0,0)
                        buttons.set(1,0)
                        buttons.set(2,0)
                        buttons.set(3,0)
                        isStarted = 0
                    }
                }
            }

        }

        btn3.setOnClickListener{
            if(isStarted == 1){
                if(buttons.elementAt(2) == 0) {
                    buttons.set(2, 1)
                    listOfNumbers.add(btn3.text.toString().toInt());
                    if (listOfNumbers.size == 4) {

                        stop = System.currentTimeMillis()
                        if (listOfNumbers.elementAt(0) <= listOfNumbers.elementAt(1) && listOfNumbers.elementAt(1) <= listOfNumbers.elementAt(2) && listOfNumbers.elementAt(2) <= listOfNumbers.elementAt(3))
                            czasTXT.text = "Udało Ci się!\n Liczby zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        else
                            czasTXT.text = "Nie udało się!\n Liczby nie zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        buttons.set(0,0)
                        buttons.set(1,0)
                        buttons.set(2,0)
                        buttons.set(3,0)
                        isStarted = 0
                    }
                }
            }

        }

        btn4.setOnClickListener{
            if(isStarted ==1){
                if(buttons.elementAt(3) == 0) {
                    buttons.set(3, 1)
                    listOfNumbers.add(btn4.text.toString().toInt());
                    if (listOfNumbers.size == 4) {

                        stop = System.currentTimeMillis()
                        if (listOfNumbers.elementAt(0) <= listOfNumbers.elementAt(1) && listOfNumbers.elementAt(1) <= listOfNumbers.elementAt(2) && listOfNumbers.elementAt(2) <= listOfNumbers.elementAt(3))
                            czasTXT.text = "Udało Ci się!\n Liczby zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        else
                            czasTXT.text = "Nie udało się!\n Liczby nie zostały odpowiednio uporządkowane! \n Wykonałeś to w czasie: " + ((stop - start) / 1000).toString() + " sekund"
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        listOfNumbers.removeLast()
                        buttons.set(0,0)
                        buttons.set(1,0)
                        buttons.set(2,0)
                        buttons.set(3,0)
                        isStarted = 0
                    }
                }
            }

        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        number = progress
        numberTXT.text = number.toString()
        czasTXT.text = ""
        btn1.text = "0"
        btn2.text = "0"
        btn3.text = "0"
        btn4.text = "0"
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        val randomValues = List(4) { Random.nextInt(0, number) }
        println(randomValues)
        textToButton1 = randomValues[0].toString();
        textToButton2 = randomValues[1].toString();
        textToButton3 = randomValues[2].toString();
        textToButton4 = randomValues[3].toString();


    }
}

