package zoo;

/**
 * Interface for zoo-to-animals communication
 */
public interface EventHandler {
    /**
     * Used for invoking a method depending on specified event
     *
     * @param event event for animals to perform a certain actions
     */
    void updateState(Events event);

}
