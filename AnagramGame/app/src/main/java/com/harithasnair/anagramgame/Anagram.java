package com.harithasnair.anagramgame;

import java.util.Random;


public class Anagram {

    public static final Random RANDOM = new Random();
    public static final String[] WORDS  = {"CAMERA", "BRISK", "POTENT", "CHEESY", "NINTH", "BLEND", "AVOID", "GASSY", "KHAKI",
                                          "BANANA","STOMP","CHILD","DENOTE","TALLER","FANCY","TUGGED","EMBARK","REMOVE","BLOOM"};

    public static String randomWord(){
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
     public static String ShuffleWord(String word){
        if(word != null && !"".equals(word)){
            char a[] = word.toCharArray();

            for( int i = 0 ; i < a.length ; i++){
                int j = RANDOM.nextInt(a.length);
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            return new String(a);
        }
        return word;
     }
}
