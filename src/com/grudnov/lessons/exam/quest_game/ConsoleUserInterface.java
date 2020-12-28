package com.grudnov.lessons.exam.quest_game;

import java.util.Scanner;

public class ConsoleUserInterface {
    private Scanner scanner;

    public ConsoleUserInterface() {
        scanner = new Scanner(System.in);
    }

    public String displayStarterMenu() {
        boolean correctInput = true;
        String str = "";
        while (correctInput) {
            System.out.println("Выберите номер пункта меню");
            System.out.println("1. Начать игру");
            System.out.println("2. Загрузить игру");
            System.out.println("3. Завершить игру");
            str = scanner.nextLine();
            if (str.equals("1") || str.equals("2") || str.equals("3")) correctInput = false;
            else System.out.println("Корректный ввод: цифра 1,2, или 3 и не как иначе)");
        }
        return str;
    }

    public String displayStep(StepQuest step) {
        boolean correctInput = true;
        String str = "";
        while (correctInput) {
            System.out.println("Выберите номер ответа.");
            System.out.println("Для сохранения нажмите \"s\" ");
            System.out.println("************************************************\n");
            System.out.println(step.getDescription());
            System.out.println("\n************************************************\n");
            System.out.println("1. " + step.getSolution_1());
            System.out.println("2. " + step.getSolution_2());
            System.out.println("\n************************************************\n");
            str = scanner.nextLine();
            if (str.equals("1") || str.equals("2") || str.equals("s") ) correctInput = false;
            else System.out.println("Корректный ввод: цифра 1 или 2, для сохранения s и не как иначе)");
        }
        if(str.equals("1")) return step.getKeySolution_1();
        if(str.equals("2")) return step.getKeySolution_2();
        if(str.equals("s")) {
            return "s";
        }
        return "null";
    }

}
