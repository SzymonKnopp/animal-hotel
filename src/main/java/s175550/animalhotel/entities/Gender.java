package s175550.animalhotel.entities;

import s175550.animalhotel.UserInterface;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromUI(UserInterface ui) throws NumberFormatException {
        ui.getPrint().print(Gender.optionsToString());
        int index = Integer.parseInt(ui.getScanner().nextLine()) - 1;
        if (index < 0 || index >= Gender.values().length) {
            throw new NumberFormatException("gender index outside of bounds");
        }
        return Gender.values()[index];
    }

    private static String optionsToString() {//TODO: try to loop-ify or check lombok's toString
        return  "1 - Male\n" +
                "2 - Female\n";
    }
}
