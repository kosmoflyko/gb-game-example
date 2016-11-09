package com.example;

import java.util.Scanner;

/**
 * Created by Vladislav Gasanov on 09.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Ваша задача угадать число");
        int range = 10;
        int number = (int) (Math.random() * range ) ;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Угадйте число от 0 до " + range);
            int input_number = scanner.nextInt();
            if (input_number == number)
            {
                System.out.println("Поздравляем вы выйграли вы отгадали число! :)");
                break;
            } else if(input_number > number) {
                System.out.println("Вы проигарли!Загадоное число меньше :(");
            } else{
                System.out.println("Вы проиграли! Загадоное число больше :( ");
            }
        }
        scanner.close();
    }
}
