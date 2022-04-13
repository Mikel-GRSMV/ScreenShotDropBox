package zoo;
/**
 * Class for describing a species of herbivore animal
 */
public class Herbivore extends AnimalSpecies {

    /**
     * Method for updating current species state, according to zoo information about herbivore type
     */
    @Override
    public void updateSpeciesState() {
        currentState = Zoo.getAllHerbivoreState();
    }

    /**
     * Method for "keeper visit" event
     * Changes state of herbivore species to MAKE_NOISE,
     * as well as a carnivore type animals (because they don't like herbivore to make noises)
     * Changes zoo info about state of a both types
     * Prints species info
     */
    @Override
    public void keeperVisit() {
        currentState = AnimalState.MAKE_NOISE;
        Zoo.setAllHerbivoreState(AnimalState.MAKE_NOISE);
        Zoo.setAllCarnivoreState(AnimalState.MAKE_NOISE);
        printDescription();
    }

    /**
     * * Method for "species feeding" event
     * Changes state of species to CALM
     * Changes zoo info about state of a herbivore type
     * Prints species info
     */
    @Override
    public void feeding() {
        currentState = AnimalState.CALM;
        Zoo.setAllHerbivoreState(AnimalState.CALM);
        printDescription();
    }

    /**
     * Method for "night time" event
     * Changes state of species to SLEEP if no one is making noises
     * Doesn't change state if anyone making noises
     * Changes zoo info about state of a herbivore type
     * Prints species info
     */
    @Override
    public void night() {
        if ( (Zoo.getAllCarnivoreState().equals(AnimalState.CALM) ||
                Zoo.getAllCarnivoreState().equals(AnimalState.SLEEP) ) &&
                (Zoo.getAllHerbivoreState().equals(AnimalState.SLEEP) ||
                        Zoo.getAllHerbivoreState().equals(AnimalState.CALM)) ) {

            System.out.println(name + " falling asleep");
            setCurrentState(AnimalState.SLEEP);
            Zoo.setAllHerbivoreState(AnimalState.SLEEP);
        } else
            System.out.println(name + " can't sleep");

        printDescription();
    }

    /**
     * Method for "morning time" event
     * Changes state of species to CALM if previous state was SLEEP
     * Doesn't change state if species wasn't sleeping
     * Changes zoo info about state of a herbivore type
     * Prints species info
     */
    @Override
    public void morning() {
        if(Zoo.getAllHerbivoreState().equals(AnimalState.SLEEP) ||
                Zoo.getAllHerbivoreState().equals(AnimalState.CALM)) {
            setCurrentState(AnimalState.CALM);
            Zoo.setAllHerbivoreState(AnimalState.CALM);
        } else
            System.out.println(name + " was noisy");

        printDescription();
    }

    /**
     * Method for "thunder strike" event
     * Changes state of species to MAKE_NOISE
     * Changes zoo info about state of a herbivore and carnivore type to MAKE_NOISE
     * Prints species info
     */
    @Override
    public void thunder() {
        setCurrentState(AnimalState.MAKE_NOISE);
        Zoo.setAllHerbivoreState(AnimalState.MAKE_NOISE);
        Zoo.setAllCarnivoreState(AnimalState.MAKE_NOISE);
        printDescription();
    }
}
