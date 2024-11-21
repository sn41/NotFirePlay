import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    static String sentence1 = "Хочешь угадаю число? Y/N";
    static String sentence2 = "Введи число от 1 до 100";
    static String sentence3 = "Я знаю! Ты загадал: ";
    static String sentence4 = "Ты ввёл нечестное число! Введи правильно!";
    static String sentence5 = "Я угадал";
    static String sentence6 = "Я не угадал";
    static String sentence7 = "Я выиграл !!! :) ";
    static String sentence8 = "Ты выиграл :( ";
    static String sentence9 = "Ну и ладно!";

    public static void main(String[] args) {
        boolean agreement = true;
        do {
            println(sentence1);
            agreement = getUserAgreement();
            if (agreement) {
                notFairPlay();
            } else {
                printOhWell();
                break;
            }
        } while (true);
    }

    private static void notFairPlay() {
        println(sentence2);
        int userNumber = getUserNumber();
        printIKnow(userNumber);
        printIWin();
    }

    private static void fairPlay() {
        println(sentence2);

        int userNumber = getUserNumber();
        int myNumber = randomForm1To100();
        printIKnow(myNumber);

        boolean isCompared =  userNumber == myNumber;
        if(isCompared){
            printIWin();
        }else {
            printYouWin();
        }

    }

    private static boolean getUserAgreement() {
        String answer = scanner.next();
        String answerLowercase = answer.toLowerCase();
        boolean userAgreement = answerLowercase.contains("y");
        return userAgreement;
    }

    private static int getUserNumber() {
        int userNumber = 0;

        do {
            userNumber = scanner.nextInt();

            if (userNumber < 1 || userNumber > 100) println(sentence4);
            else break;

        } while (true);

        return userNumber;
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void print(String string) {
        System.out.print(string);
    }

    private static void  printOhWell() {
        println(sentence9);
    }

    private static void printIWin() {
        println(sentence5);
        println(sentence7);
    }

    private static void printYouWin() {
        println(sentence6);
        println(sentence8);
    }

    private static void printIKnow(int userNumber) {
        println(sentence3 + " " + userNumber);
    }

    private boolean askAndGenerateRandomAndCompare(){
        int userNumber = getUserNumber();
        int myNumber = randomForm1To100();
        return userNumber == myNumber;
    }

    private static int randomForm1To100() {
        double doubleRandmon = Math.random();
        int intRandom = (int) (doubleRandmon * 100);
        return intRandom;
    }

}