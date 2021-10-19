package s175550.animalhotel;

import lombok.Getter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class UserInterface {
    private final Scanner scanner;
    private final PrintStream print;

    public enum Command {
        LIST_AVAILABLE_COMMANDS,
        LIST_ENTITY_CATEGORIES,
        LIST_ENTITIES_FROM_CATEGORY,
        ADD_NEW_ENTITY,
        DELETE_ENTITY,
        STOP_APPLICATION;

        private static Command getCommandByLetter(String letter) throws IllegalArgumentException {
            switch (letter) {
                case "h": return Command.LIST_AVAILABLE_COMMANDS;
                case "c": return Command.LIST_ENTITY_CATEGORIES;
                case "e": return Command.LIST_ENTITIES_FROM_CATEGORY;
                case "a": return Command.ADD_NEW_ENTITY;
                case "d": return Command.DELETE_ENTITY;
                case "x": return Command.STOP_APPLICATION;
                default: throw new IllegalArgumentException("invalid command");
            }
        }
    }

    public UserInterface(PrintStream print, InputStream input) {
        this.print = print;
        this.scanner = new Scanner(input);
    }

    public void displayHeader() {
        print.println();
        print.println("-- Animal Hotel Data System --");
        print.println("h - list available commands");
    }

    public void displayCommandAwait() {
        print.println("-------------------");
        print.println("Awaiting command...");
    }

    public void displayCommands() {
        print.println("h - list available commands");
        print.println("c - list entity categories");
        print.println("e - list entities from category");
        print.println("a - add new entity");
        print.println("d - delete entity");
        print.println("x - stop application");
    }

    public void displayEntityClasses() {
        for (int i = 0; i < AppRunner.EntityClass.values().length; i++) {
            print.println((i + 1) + " - " + AppRunner.EntityClass.values()[i].toString());
        }
    }

    public <EntityType> void displayEntities(ArrayList<EntityType> entityList) {
        for (int i = 0; i < entityList.size(); i++) {
            print.println((i + 1) + " - " + entityList.get(i).toString());
        }
    }

    public void displayMessage(String message) {
        print.println(message);
    }

    public Command getCommand() throws IllegalArgumentException {
        return Command.getCommandByLetter(scanner.nextLine());
    }
}
