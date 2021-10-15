package s175550.animalhotel.entities.animal;

import s175550.animalhotel.UserInterface;

public enum Species {
    DOG,
    CAT,
    PARROT,
    SNAKE,
    HAMSTER,
    RAT,
    GUINEA_PIG,
    WOMBAT;

    public static Species fromUI(UserInterface ui) throws NumberFormatException {
        ui.getPrint().print(Species.optionsToString());
        int index = Integer.parseInt(ui.getScanner().nextLine()) - 1;
        if (index < 0 || index >= Species.values().length) {
            throw new NumberFormatException("species index outside of bounds");
        }
        return Species.values()[index];
    }

    private static String optionsToString() {
        return  "1. Dog\n" +
                "2. Cat\n" +
                "3. Parrot\n" +
                "4. Snake\n" +
                "5. Hamster\n" +
                "6. Rat\n" +
                "7. Guinea Pig\n" +
                "8. Wombat\n";
    }
}
