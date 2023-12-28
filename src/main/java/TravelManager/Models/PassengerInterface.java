package TravelManager.Models;

import java.util.List;

/**
 * The interface representing a passenger in a travel package. Passengers have a name, a number,
 * and methods to get their name, number, and activities enrolled. They can also sign up for activities.
 */
public interface PassengerInterface {

    /**
     * Gets the name of the passenger.
     *
     * @return The name of the passenger.
     */
    String getPassengerName();

    /**
     * Gets the unique number assigned to the passenger.
     *
     * @return The passenger number.
     */
    int getPassengerNumber();

    /**
     * Gets the list of activities in which the passenger is enrolled.
     *
     * @return The list of activities enrolled by the passenger.
     */
    List<ActivityInterface> getActivitiesEnrolled();

    /**
     * Signs up the passenger for a specified activity.
     *
     * @param activity The activity to sign up for.
     */
    void signUpForActivity(ActivityInterface activity);
}
