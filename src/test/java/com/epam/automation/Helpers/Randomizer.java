package com.epam.automation.Helpers;

public class Randomizer {

    public static int getRandomNumber(){
        int min = 1;
        int max = 100;

        int randomNumber = min + (int)(Math.random() * max);
        return randomNumber;
    }

}
