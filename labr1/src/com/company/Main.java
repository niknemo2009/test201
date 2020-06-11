package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	System.out.print(cyr2lat("УКРАЇНА"));
	System.out.print(register("\n" + "DesIGn"+"\n"));
	revers("doppelganger");
	alphabet_sort();
	System.out.print(vowelscount("Україна"));
    }

        public String cyr2lat(char ch){     //Завдання 16
            switch (ch){
                case 'А': return "A";
                case 'Б': return "B";
                case 'В': return "V";
                case 'Г': return "G";
                case 'Д': return "D";
                case 'Е': return "E";
                case 'Є': return "JE";
                case 'Ж': return "ZH";
                case 'З': return "Z";
                case 'И': return "IH";
                case 'І': return "I";
                case 'Ї': return "YI";
                case 'Й': return "Y";
                case 'К': return "K";
                case 'Л': return "L";
                case 'М': return "M";
                case 'Н': return "N";
                case 'О': return "O";
                case 'П': return "P";
                case 'Р': return "R";
                case 'С': return "S";
                case 'Т': return "T";
                case 'У': return "U";
                case 'Ф': return "F";
                case 'Х': return "KH";
                case 'Ц': return "C";
                case 'Ч': return "CH";
                case 'Ш': return "SH";
                case 'Щ': return "JSH";
                case 'Ь': return "JH";
                case 'Ю': return "JU";
                case 'Я': return "JA";
                default: return String.valueOf(ch);
            }
        }

        public String cyr2lat(String s){
            StringBuilder sb = new StringBuilder(s.length()*2);
            for(char ch: s.toCharArray()){
                sb.append(cyr2lat(ch));
            }
            return sb.toString();
        }
        public String register(String s){                         // Завдання 17
        StringBuilder sb = new StringBuilder(s.length()*2);
        char temp;
        for (char ch: s.toCharArray()) {
            if(Character.isUpperCase(ch) ){
                temp = Character.toLowerCase(ch);
                sb.append(temp);
            }
            else{
                temp = Character.toUpperCase(ch);
                sb.append(temp);
            }
        }
        return sb.toString();
        }
        public void alphabet_sort(){                            // Завдання 18
            String[] seasons = new String[] {"Winter", "Summer", "Spring", "Autumn"};
            String temp;
            for (int j = 0; j < str.length; j++) {
                for (int i = j + 1; i < str.length; i++) {
                    if (str[i].compareTo(str[j]) < 0) {
                        temp = str[j];
                        str[j] = str[i];
                        str[i] = temp;
                    }
                }
                System.out.println(str[j]);
            }
        }

        public void revers(String s) {                         //Завдання 19
            char[] reverseS = s.toCharArray();
            for (int i = s.length()-1;i>=0;i--){
                System.out.print(reverseS[i]);
            }
        }
        public int vowelscount(String s){                   // Завдання 20
        int count = 0;
        for (char ch: s.toCharArray()){
            if (isVowel(ch)==true){
                count++;
            }
        }
        return count;
        }
        char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'і', 'е', 'о', 'є'};
        public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        for(char c: vowels){
            if (ch==c){
                return true;
            }
        }
        return false;
    }
    }

