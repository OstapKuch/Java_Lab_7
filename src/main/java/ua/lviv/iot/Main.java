package ua.lviv.iot;

import java.util.Scanner;

public final class Main {

    private Main() {

    }

    public static void main(final String[] args) {

        StringProcessor test = new StringProcessor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter");
        String input = sc.nextLine();

        test.addToList("a");
        test.addToList("an");
        test.addToList("the");
        test.addToList("in");
        test.addToList("or");
        test.addToList("are");
        test.addToList("on");
        test.addToList("out");

        test.showResults(test.deleteArticles(input));


    }

}
