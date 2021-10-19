package s175550.animalhotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import s175550.animalhotel.entities.animal.Animal;
import s175550.animalhotel.entities.animal.AnimalRepository;
import s175550.animalhotel.entities.animal.AnimalService;
import s175550.animalhotel.entities.owner.Owner;
import s175550.animalhotel.entities.owner.OwnerRepository;
import s175550.animalhotel.entities.owner.OwnerService;

@Component
public class AppRunner implements CommandLineRunner {
    public enum EntityClass {
        OWNER,
        ANIMAL;

        @Override
        public String toString() {
            switch (this) {
                case OWNER: return "Owner";
                case ANIMAL: return "Animal";
                default: throw new IllegalStateException("unhandled enum value present");
            }
        }

        public static AppRunner.EntityClass entityClassFromUI(UserInterface ui) throws NumberFormatException {
            ui.displayEntityClasses();
            int index = Integer.parseInt(ui.getScanner().nextLine()) - 1;
            if (index < 0 || index >= AppRunner.EntityClass.values().length) {
                throw new NumberFormatException("entity class index outside of bounds");
            }
            return AppRunner.EntityClass.values()[index];
        }
    }

    @Override
    public void run(String... args) throws Exception {
        Storage storage = new Storage();
        DataInitializer.initializeData(storage);

        OwnerService ownerService = new OwnerService(new OwnerRepository(storage));
        AnimalService animalService = new AnimalService(new AnimalRepository(storage));

        UserInterface ui = new UserInterface(System.out, System.in);

        loopUserInteractionUntilExit(ui, ownerService, animalService);
    }

    private void loopUserInteractionUntilExit(UserInterface ui, OwnerService ownerService, AnimalService animalService) {
        ui.displayHeader();
        while (true) {
            ui.displayCommandAwait();
            try {
                switch (ui.getCommand()) {
                    case LIST_AVAILABLE_COMMANDS: ui.displayCommands(); break;

                    case LIST_ENTITY_CATEGORIES: ui.displayEntityClasses(); break;

                    case LIST_ENTITIES_FROM_CATEGORY: {
                        ui.displayMessage("Choose category of entities to display:");
                        switch (EntityClass.entityClassFromUI(ui)) {
                            case OWNER: ui.displayEntities(ownerService.getAll()); break;
                            case ANIMAL: ui.displayEntities(animalService.getAll()); break;
                            default: throw new IllegalStateException("unhandled enum value present");
                        }
                        break;
                    }

                    case ADD_NEW_ENTITY: {
                        ui.displayMessage("Choose category of entity to add:");
                        switch (EntityClass.entityClassFromUI(ui)) {
                            case OWNER: ownerService.add(Owner.createOwnerFromUI(ui)); break;
                            case ANIMAL: animalService.add(Animal.createAnimalFromUI(ui, ownerService)); break;
                            default: throw new IllegalStateException("unhandled enum value present");
                        }
                        ui.displayMessage("Successfully added new entity.");
                        break;
                    }

                    case DELETE_ENTITY: {
                        ui.displayMessage("Choose category of entity to delete:");
                        switch (EntityClass.entityClassFromUI(ui)) {
                            case OWNER: {
                                Owner toDelete = ownerService.ownerFromUI(ui);
                                ownerService.delete(toDelete);
                                break;
                            }
                            case ANIMAL: {
                                Animal toDelete = animalService.animalFromUI(ui);
                                animalService.delete(toDelete);
                                break;
                            }
                            default: throw new IllegalStateException("unhandled enum value present");
                        }
                        break;
                    }

                    case STOP_APPLICATION: {
                        ui.displayMessage("Exiting application...");
                        return;
                    }

                    default: throw new IllegalStateException("unhandled enum value present");
                }
            }
            catch (Exception ex) {
                ui.displayMessage("An error occurred: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
                //ex.printStackTrace(ui.getPrint());
            }
        }
    }
}
