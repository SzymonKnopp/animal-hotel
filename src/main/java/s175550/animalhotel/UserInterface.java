package s175550.animalhotel;

import lombok.Getter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Getter
public class UserInterface {
    private final Scanner scanner;
    private final PrintStream print;

    public UserInterface(PrintStream print, InputStream input) {
        this.print = print;
        this.scanner = new Scanner(input);
    }

    public void getUserAction() {
        scanner.nextLine();
    }

    public void displayHeader() {
        print.println(" -- Animal Hotel Data System -- ");
        print.println("h - list available commands");
    }

    public void displayCommands() {
        print.println("c - list entity categories");
        print.println("e - list entities from category");
        print.println("a - add new entity");
        print.println("d - delete entity");
    }

    public void displayCategories() {
        print.println("1. Owner");
        print.println("2. Animal");
    }
}
