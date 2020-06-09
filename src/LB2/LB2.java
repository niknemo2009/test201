package LB2;

import java.util.Arrays;
import java.util.Scanner;

public class LB2 {


    /*34 - Создайте тестовый класс, демонстрирующий работу не менее 15 методов класса Arrays*/
    public static void main(String[] args) {
        int b = 90;
        int c = b > 100 && 7 / 0 > 12 ? 120 : 130;
        System.out.println(c);
        switch (b) {
            case 80:
                break;
            default:
                System.out.println("aaa");
        }
    }
}