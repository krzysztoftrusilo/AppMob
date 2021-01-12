#Projekt zaliczeniowy, aplikacje mobilne

Aplikacja wykonuje założenia prostej gry logicznej, której
celem jest mierzenie czasu, poprawnego ułożenia kolejności
wylosowanych liczb. Powtarzające się liczby przy losowaniu
są umyślnie wprowadzone w celu utrudnienia zadania. Kolejność
zaznaczenia tych samych liczb nie wpływa na wynik.

Ma to na celu skupienie uwagi gracza na wszystkich liczbach,
zamiast poszukiwania kolejnej. Dla przykładu kombinacja: 1,2,2,3.
Po zaznaczeniu liczby 2, umysł domyślnie przeskoczy na szukanie 3,
pawdopodobnie przegapiając drugą liczbę 2.

Aplikacja wykonana jest w języku kotlin.

##Zmienne

*Stop* i *start* służą jako flagi, podobnie do zmiennej *isStarted*, pilnujące stanu gry.
Początkowe wartości przechowywane w przyciskach zostały oznaczone zerami i są bezpośrednio
przekazywane do przycisków. *listOfNumbers* przechowuje listę odpowiedzi wybieranych kolejno
przez gracza dodając je do listy, która potem jest weryfikowana. *buttons* przechowuje informacje
o fladze (włączeniu) przycisków.

###Funkcje

Poniższa konfiguracja nasłuchuje zmian suwaka, aby losowac w tajemnicy przed graczem
kombinacje liczb, która ujawni się po rozpoczęciu gry.

`    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
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


    }`

Wcześniej wygenerowane wartości za pomocą suwaka, po starcie gry zostają ujawnione, flaga stanu gry
oznajmia uruchomioną grę i odliczanie czasu.

`       seekBar.setOnSeekBarChangeListener(this)
        btnStart.setOnClickListener {
            btn1.text = textToButton1
            btn2.text = textToButton2
            btn3.text = textToButton3
            btn4.text = textToButton4
            isStarted = 1
            start = System.currentTimeMillis();`

Jeśli gra się rozpoczęła po kliknięciu konkretnego przycisku, znajdywanego po indeksie przechodzimy do
sprawdzenia, czy dany przycisk przypadkiem nie był już wciśnięty i ustawiamy jego flagę na stan bycia
wciśniętym i dodajemy do listy przechowującej kolejność wybraną przez gracza. Następnie upewniamy się
czy dany przycisk nie był ostatnim. Jeśli tak przechodzimy do sprawdzenia listy gracza i wyświetlamy
stosowny komunikat. Po sprawdzeniu lista gracza zostaje wyczyszczona, a flai przycisków zresetowane,
aby były gotowe na kolejny start. Przyciski obsługiwane są analogicznym kodem.

`       btn1.setOnClickListener{
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


        }`