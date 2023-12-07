package za.org.capaciti;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double income;
        double deductions;
        String type;

        Scanner scan = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("What type of tax would you like to calculate? (Type in full)");
        System.out.println("""
                1. Income tax
                2. updating soon...
                """);
        type = scan.nextLine();
        System.out.println("``````````````````````````````````````````````");

        if (type.equalsIgnoreCase("income tax")) {
            System.out.println("Enter your income amount: ");
            income = scan.nextDouble();

            System.out.println("Enter your deductions amount: ");
            deductions = scan.nextDouble();

            double tax = calculateIncomeTax(income, deductions);

            if (tax != -1) {
                System.out.printf("Calculated tax: R %.2f%n", tax);
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static double calculateIncomeTax(double income, double deductions) {
        double taxAmount;
        double deductedAmount = income - deductions;

        if (deductedAmount >= 1 && deductedAmount <= 237100) {

            taxAmount = deductedAmount * (18.0 / 100);

        } else if (deductedAmount >= 237101 && deductedAmount <= 370500) {

            taxAmount = 42678 + ((deductedAmount - 237100) * (26.0 /100));

        } else if (deductedAmount >= 370501 && deductedAmount <= 512800) {

            taxAmount = 77362 + ((deductedAmount - 370500) * (31.0 /100));

        } else {

            System.out.println("Invalid input");
            return -1;

        }
        return taxAmount;
    }
}