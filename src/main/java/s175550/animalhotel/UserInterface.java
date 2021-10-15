package s175550.animalhotel;

import lombok.Getter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Getter
public class UserInterface {
    private final Scanner scanner;
    private final PrintStream print;

    public enum Command {
        LIST_ENTITY_CATEGORIES,
        LIST_ENTITIES_FROM_CATEGORY,
        ADD_NEW_ENTITY,
        DELETE_ENTITY,
        STOP_APPLICATION
    }

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
        print.println("x - stop application");
    }

    public void displayCategories() {
        print.println("1. Owner");
        print.println("2. Animal");
    }

    public Command getCommand() throws IllegalArgumentException {
        switch (scanner.nextLine()) {
            case "c": return Command.LIST_ENTITY_CATEGORIES;
            case "e": return Command.LIST_ENTITIES_FROM_CATEGORY;
            case "a": return Command.ADD_NEW_ENTITY;
            case "d": return Command.DELETE_ENTITY;
            case "x": return Command.STOP_APPLICATION;
            default: throw new IllegalArgumentException("invalid command");
        }
    }
}
