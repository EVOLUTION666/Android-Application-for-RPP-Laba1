package com.example.laba1;

public class IntRetranslator {
    static String [][] toHundred = { {"","од","дв","три","четыре","пять","шесть","семь","восемь","девять"},
            {"", "десять " ,"двадцать ","тридцать ","сорок ","пятьдесят ","шестьдесят ","семьдесят ","восемьдесят ","девяносто "},
            {"","сто ","двести ","триста ","четыреста ","пятьсот ","шестьсот ","семьсот ","восемьсот ","девятьсот "} };
    static String[] elevenToNineteen = {"десять ","одиннадцать ","двенадцать ","тринадцать ","четырнадцать ","пятнадцать ","шестнадцать ",
            "семнадцать ","восемнадцать ","девятнадцать "};
    static String[][] thousandsAndMillions = {{"", "", "", ""},
            {"миллиардов ", "миллионов ", "тысяч ", ""},
            {"миллиард ", "миллион ", "тысяча ", ""},
            {"миллиарда ", "миллиона ", "тысячи ", ""},
            {"миллиардов ", "миллионов ", "тысяч ", ""}};
    public static String retranslate(long number) {
        String text = "";
        if(number == 0)
        {
            return  "ноль";
        }
        int million = (int) (number)/ 1000000 ;
        int thousand = (int) (number-(million*1000000)) / 1000;
        int lasts = (int) (number % 1000);
        return text + toThousands (million , 1)+toThousands(thousand , 2)+toThousands(lasts , 3);
    }
    private static String toThousands(int value, int index) {
        int hundreds = value/100;
        int decimal = (value - (hundreds*100)) / 10;
        int units = value % 10;
        String text = "";
        if ( decimal == 1 ) text = toHundred [2] [hundreds] + elevenToNineteen [units];
        else text = toHundred [2] [hundreds] + toHundred [1][decimal] + toHundred [0] [units];

        // формируем окончания в единицах
        if (index == 2) {if (units == 1 && decimal != 1) text = text + "на ";
        else if (units == 2 & decimal != 1) text = text + "е ";
            if (units > 1 && decimal != 1) text = text + " ";}
        else {if (units == 1 && decimal != 1) text = text + "ин ";
            if (units == 2 & decimal != 1) {text = text + "а ";}
            else if (units != 0 & decimal != 1) text = text + " ";}

        // дописываем степень числа
        int indexA = 0;
        if (value != 0 ) {
            if (units == 0 || decimal == 1 )   indexA = 1;
            else if (units == 1)              indexA = 2;
            else if (units > 1 & units < 5)  indexA = 3;
            else                            indexA = 4;}
        text = text + thousandsAndMillions [indexA][index];
        return text;
    }

    public static void main(String[] args) {
        System.out.println(IntRetranslator.retranslate(1000000));
    }
}
