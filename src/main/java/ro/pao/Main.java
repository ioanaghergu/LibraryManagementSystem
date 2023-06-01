package ro.pao;

import ro.pao.application.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.introMember();

            menu.introBook();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }

    }
}
