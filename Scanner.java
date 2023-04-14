package org.example;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // Создаем экземпляр класса Scanner.
        // Используйте один экземпляр класса во всей программе.
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Как тебя зовут?");
        // Метод nextLine() возвращает введенную строку.
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
        
        System.out.println("Сколько тебе лет?");
        // Метод nextInt() возвращает введенное целое число.
        // Что-бы вернуть число типа long существует метод nextLong().
        int age = scanner.nextInt();
        System.out.println("Ого! " + age + "!");
        
        System.out.println("Введи значение ускорения свободного падения в м/с²:");
        // Метод nextDouble() возвращает введенное число с плавающей точкой с типом double.
        // Что-бы вернуть число типа float существует метод nextFloat().
        double g = scanner.nextDouble();
        System.out.println("Кто бы мог подумать, что ускорение свободного падения это " + g + " м/с²!" );
        
        // Закрываем Scanner по завершении работы.
        scanner.close();
    }
} 