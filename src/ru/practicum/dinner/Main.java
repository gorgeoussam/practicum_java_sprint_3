package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> {
                    return;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("choose option:");
        System.out.println("1 - add new dish");
        System.out.println("2 - generate combo");
        System.out.println("3 - sortie");
    }

    private static void addNewDish() {
        System.out.println("enter dish type:");
        String dishType = scanner.nextLine();
        System.out.println("enter dish name:");
        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("combining meal...");

        System.out.println("enter amount of combos to generate:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("eneter dish type, dividing it with (enter). Enter blank line to complete");
        String nextItem = scanner.nextLine();


        ArrayList<String> selectedTypes = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                selectedTypes.add(nextItem);
            } else {
                System.out.println("can't cook this type yet, try something else!");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        ArrayList<ArrayList<String>> generatedCombos = dc.generateCombos(numberOfCombos, selectedTypes);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Combo " + (i + 1));
            System.out.println(generatedCombos.get(i));
        }
    }
}
