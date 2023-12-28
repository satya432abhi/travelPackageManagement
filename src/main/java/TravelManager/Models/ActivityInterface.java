package TravelManager.Models;

/**
 * The interface representing an activity that passengers can sign up for.
 * Activities have a name, description, cost, capacity, and a method to check if a passenger can sign up.
 */
public interface ActivityInterface {

    /**
     * Gets the name of the activity.
     *
     * @return The name of the activity.
     */
    String getActivityName();

    /**
     * Gets the description of the activity.
     *
     * @return The description of the activity.
     */
    String getActivityDescription();

    /**
     * Gets the cost of the activity.
     *
     * @return The cost of the activity.
     */
    double getActivityCost();

    /**
     * Gets the capacity of the activity.
     *
     * @return The capacity of the activity.
     */
    int getActivityCapacity();

    /**
     * Checks if a passenger can sign up for the activity.
     *
     * @return True if the passenger can sign up; otherwise, false.
     */
    boolean canSignUpPassenger();
}

