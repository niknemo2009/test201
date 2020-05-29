package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Authorization {



    private static ArrayList<String> BlackList = new ArrayList<>();
    private enum LoginPass{
        TOM("123"),
        JERRY("321"),
        ADMIN("0");
        String password;
        LoginPass(String password){
            this.password = password;
        }
    }

    Authorization() {
        AuthorizationProcess();
    }

    private void AuthorizationProcess(){
        boolean Check = false;
        String CurrentUser = CurrentUser();
        if (BlackListCheck(CurrentUser)){
            System.out.print("\nКористувач не може здійснити вхід у поточній сесії");
            CurrentUser = CurrentUser();
        }
        else Check = Password_check(CurrentUser);
        if (Check){
            System.out.print("Ласкаво просимо, " + CurrentUser);
        }
        else{
            System.out.print("\nСпробуйте іншого користувача");
            AuthorizationProcess();
        }
    }

    private boolean BlackListCheck(String CurrentUser){
        for (String name: BlackList){
            if (name.equals(CurrentUser)){
                return true;
            }
        }
        return false;
    }

    private boolean Password_check(String name ) {
        int count = 0;
        while (count != 3)
        {
            if (count == 2)
            {
                System.out.print("\nОстання спроба входу");
            }
            switch (name)
            {
                case ("Tom"):
                    if (Congruence(LoginPass.TOM)){
                        return true; }
                    else{
                        System.out.print("\nНевірний пароль");
                        count++;
                        break; }
                case ("Jerry"):
                    if (Congruence(LoginPass.JERRY)){
                        return true; }
                    else{
                        System.out.print("\nНевірний пароль");
                        count++;
                        break; }
                case ("Admin"):
                    if (Congruence(LoginPass.ADMIN)){
                        return true; }
                    else{
                        System.out.print("\nНевірний пароль");
                        count++;
                        break; }
                default:
                    System.out.print("\nКористувача не існує");
                    return false;
            }
        }
        BlackList.add(name);
        return false;
    }

    private boolean Congruence(LoginPass Name){
       Scanner scanner = new Scanner(System.in);
       System.out.print("\nВведіть пароль: ");
       String incompassword;
       incompassword = scanner.nextLine();
       return Name.password.equals(incompassword);
   }

    private static String CurrentUser(){
        System.out.print("\nВведіть ім'я користуача: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
