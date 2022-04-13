package zoo;

/**
 * Class for user-based action trigger.
 * Use it to invoke an event for a concrete zoo
 */
public class ActionTrigger {

    /**
     * Link to a concrete zoo
     */
    private Zoo zoo;

    /**
     * @param sourceZoo concrete zoo for binding to link
     */
    public ActionTrigger(Zoo sourceZoo) {
        zoo = sourceZoo;
    }

    /**
     * Method for invoking "Keeper visit" event for all animals of specified type
     *
     * @param animalType type of animals to visit (carnivore/herbivore)
     */
    void visit(AnimalType animalType) {
        System.out.println("\n--- Visiting " + animalType.name() + " ---");
        zoo.performAction(Events.KEEPER_VISIT, animalType);
    }

    /**
     * Method for invoking "Feeding animals" event for all animals of specified type
     *
     * @param animalType type of animals to visit (carnivore/herbivore)
     */
    void feedAnimals(AnimalType animalType) {
        System.out.println("\n--- Feeding " + animalType.name() + " ---");
        zoo.performAction(Events.FEEDING, animalType);
    }

    /**
     * Method for invoking "night time" event for all animals in the zoo
     */
    void setNight() {
        System.out.println("\n--- Set night ---");
        zoo.performAction(Events.NIGHT);
    }

    /**
     * Method for invoking "morning time" event for all animals in the zoo
     */
    void setMorning() {
        System.out.println("\n--- Set morning ---");
        zoo.performAction(Events.MORNING);
    }
    /**
     * Method for invoking "thunder" event for all animals in the zoo
     */
    void setThunder() {
        System.out.println("\n--- Set thunder ---");
        zoo.performAction(Events.THUNDER);
    }
}
