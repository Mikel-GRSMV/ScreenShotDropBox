package zoo;

import lombok.Getter;
import lombok.Setter;

/**
 * Class for concrete animal species
 */
@Getter
@Setter
abstract class AnimalSpecies implements EventHandler {

    /**
     * State of a species
     */
    protected AnimalState currentState;
    /**
     * Name of a species
     */
    protected String name;
    /**
     * Amount of animals of a species
     */
    protected int amount;

    /**
     * Defines a species default state to CALM
     */
    public AnimalSpecies() {
        currentState = AnimalState.CALM;
    }

    /**
     * Defines a behavior on "keeper visit" event
     */
    abstract public void keeperVisit();

    /**
     * Defines a behavior on "feeding a species" event
     */
    abstract public void feeding();

    /**
     * Defines a behavior on "night time" event
     */
    abstract public void night();

    /**
     * Defines a behavior on "morning time" event
     */
    abstract public void morning();

    /**
     * Defines a behavior on "thunder strike" event
     */
    abstract public void thunder();

    /**
     * Defines a behavior for updating current state, according to zoo info about type
     */
    abstract public void updateSpeciesState();

    /**
     * Prints values of species fields
     */
    public void printDescription() {
        System.out.println(toString());
    }

    /**
     * Defines a behavior, depending on specified event
     * @param event event for animals to perform a certain actions
     */
    @Override
    public void updateState(Events event) {
        switch (event) {
            case KEEPER_VISIT:
                keeperVisit();
                break;
            case FEEDING:
                feeding();
                break;
            case NIGHT:
                night();
                break;
            case MORNING:
                morning();
                break;
            case THUNDER:
                thunder();
                break;
            case UPDATE_STATE:
                updateSpeciesState();
                break;
            default:
                System.out.println("Unknown event");
        }
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ". Name: " + name  + ". State: " + currentState;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnimalSpecies other = (AnimalSpecies) obj;
        if (amount != other.amount)
            return false;
        if (!name.equals(other.name))
            return false;
        if (!currentState.equals(other.currentState))
            return false;
        return true;
    }

}
