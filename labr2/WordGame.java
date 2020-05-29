package com.company;

import java.util.Scanner;

public class WordGame {
    final String winword = "переможець";
    int count_attempt = 1;
    String starword = "";

    WordGame(){StartGame();};

    private void StartGame()
    {
        WordToStar(winword);
        Guessing();
    }
    private String WordToStar(String word){
        int count = 0;
        char[] wordarray = word.toCharArray();
        for(char c: wordarray)
        {
            count++;
        }

        for (int i=0; i<count;i++)
        {
            starword = starword.concat("*");
        }
        System.out.println("Слово для відгадування: " +starword);
        return starword;
    }

    private void Guessing()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть букву: ");
        String attempt = sc.nextLine();
        if (AnyMoreStars()) Victory();
        if (attempt.equalsIgnoreCase(winword)) {Victory();}
        else {
            if (CheckLength(attempt)) {
                while (count_attempt != 10) {
                    if (Checking(attempt)) {
                        System.out.println("Відкрити букву");
                        count_attempt++;
                        starword = ChangeStar(attempt, starword);
                        Guessing();

                    } else {
                        System.out.println("Немає такого");
                        count_attempt++;
                        Guessing();

                    }
                }
            } else {
                System.out.println("Допускається тільки буква або слово");
                Guessing();
            }
        }
    }
    private boolean Checking(String attempt)
    {
        if(winword.contains(attempt)){
            return true;
        } else return false;

    }

    private boolean CheckLength(String attempt){
        if (attempt.length() ==1 || attempt.length()==winword.length()){
            return true;
        }
            else return false;
    }
    private String ChangeStar( String k, String stars){
        char[] starword = stars.toCharArray();
        char[] k2 = k.toCharArray();
        char[] winner = winword.toCharArray();
        for(int i = 0;i<winner.length;i++){
            if (winner[i] == k2[0]){
                starword[i]=k2[0];
            }
        }
        stars = new String(starword);
        System.out.println(stars);

        return stars;
    }

    private void Victory(){
        System.out.println("Перемога!!! Слово: " + winword);
        System.exit(0);
    }
    private boolean AnyMoreStars(){
        for(char ch: starword.toCharArray()){
            if (ch == '*'){
                return false;
            }
        }
        return true;
    }

    }


