package s175550.animalhotel.model.animal;

public enum Species {
    DOG,
    CAT,
    PARROT,
    SNAKE,
    HAMSTER,
    RAT,
    GUINEA_PIG,
    WOMBAT;

    private static String optionsToString() {
        return  "1 - Dog\n" +
                "2 - Cat\n" +
                "3 - Parrot\n" +
                "4 - Snake\n" +
                "5 - Hamster\n" +
                "6 - Rat\n" +
                "7 - Guinea Pig\n" +
                "8-  Wombat\n";
    }
}
