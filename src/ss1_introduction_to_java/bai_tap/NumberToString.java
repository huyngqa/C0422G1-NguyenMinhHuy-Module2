package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        System.out.println("Convert numbers to letters");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = Integer.parseInt(sc.nextLine());

        if (number < 10) {
            switch (number) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number < 20) { // các số bé hơn 20
            int unit = number % 10;
            switch (unit) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number < 100) { // các số từ 20 đến 99
            int tmp = number / 10;
            int unit = number % 10;
            switch (tmp) {
                case 2:
                    System.out.print("twenty");
                    break;
                case 3:
                    System.out.print("thirty");
                    break;
                case 4:
                    System.out.print("forty");
                    break;
                case 5:
                    System.out.print("fifty");
                    break;
                case 6:
                    System.out.print("sixty");
                    break;
                case 7:
                    System.out.print("seventy");
                    break;
                case 8:
                    System.out.print("eighty");
                    break;
                case 9:
                    System.out.print("ninety");
                    break;
            }
            switch (unit) {
                case 1:
                    System.out.print(" one");
                    break;
                case 2:
                    System.out.print(" two");
                    break;
                case 3:
                    System.out.print(" three");
                    break;
                case 4:
                    System.out.print(" four");
                    break;
                case 5:
                    System.out.print(" five");
                    break;
                case 6:
                    System.out.print(" six");
                    break;
                case 7:
                    System.out.print(" seven");
                    break;
                case 8:
                    System.out.print(" eight");
                    break;
                case 9:
                    System.out.print(" nine");
                    break;
            }
        } else if (number < 1000) {
            int hundred = number / 100;
            int tmp = (number / 10) % 10;
            int unit = number % 10;
            switch (hundred) {
                case 1:
                    System.out.print("one hundred");
                    break;
                case 2:
                    System.out.print("two hundred");
                    break;
                case 3:
                    System.out.print("three hundred");
                    break;
                case 4:
                    System.out.print("four hundred");
                    break;
                case 5:
                    System.out.print("five hundred");
                    break;
                case 6:
                    System.out.print("six hundred");
                    break;
                case 7:
                    System.out.print("seven hundred");
                    break;
                case 8:
                    System.out.print("eight hundred");
                    break;
                case 9:
                    System.out.print("nine hundred");
                    break;
            }
            if (tmp == 1) {
                switch (unit) {
                    case 0:
                        System.out.print(" and ten");
                        break;
                    case 1:
                        System.out.print(" and eleven");
                        break;
                    case 2:
                        System.out.print(" and twelve");
                        break;
                    case 3:
                        System.out.print(" and thirteen");
                        break;
                    case 4:
                        System.out.print(" and fourteen");
                        break;
                    case 5:
                        System.out.print(" and fifteen");
                        break;
                    case 6:
                        System.out.print(" and sixteen");
                        break;
                    case 7:
                        System.out.print(" and seventeen");
                        break;
                    case 8:
                        System.out.print(" and eighteen");
                        break;
                    case 9:
                        System.out.print(" and nineteen");
                }
            } else {
                switch (tmp) {
                    case 2:
                        System.out.print(" and twenty");
                        break;
                    case 3:
                        System.out.print(" and thirty");
                        break;
                    case 4:
                        System.out.print(" and forty");
                        break;
                    case 5:
                        System.out.print(" and fifty");
                        break;
                    case 6:
                        System.out.print(" and sixty");
                        break;
                    case 7:
                        System.out.print(" and seventy");
                        break;
                    case 8:
                        System.out.print(" and eighty");
                        break;
                    case 9:
                        System.out.print(" and ninety");
                        break;
                }
                switch (unit) {
                    case 1:
                        System.out.print(" one");
                        break;
                    case 2:
                        System.out.print(" two");
                        break;
                    case 3:
                        System.out.print(" three");
                        break;
                    case 4:
                        System.out.print(" four");
                        break;
                    case 5:
                        System.out.print(" five");
                        break;
                    case 6:
                        System.out.print(" six");
                        break;
                    case 7:
                        System.out.print(" seven");
                        break;
                    case 8:
                        System.out.print(" eight");
                        break;
                    case 9:
                        System.out.print(" nine");
                }
            }
        } else {
            System.out.println("out of ability");
        }
    }
}
