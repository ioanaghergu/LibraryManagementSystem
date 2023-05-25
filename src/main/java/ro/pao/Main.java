package ro.pao;

import ro.pao.application.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.introAuthor();

            menu.introBook();

            menu.introBookCopy();

            menu.introMember();

            menu.introFine();

            //menu.introLoan();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }

    }
}