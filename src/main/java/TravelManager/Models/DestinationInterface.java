package TravelManager.Models;

import java.util.HashMap;
import java.util.List;

/**
 * The interface representing a destination in a travel package. Destinations have a name, a list of activities,
 * and a method to add an activity to the destination.
 */
public interface DestinationInterface {

    /**
     * Gets the name of the destination.
     *
     * @return The name of the destination.
     */
    String getDestinationName();

    /**
     * Gets the list of activities available at the destination.
     *
     * @return The list of activities available at the destination.
     */
    List<ActivityInterface> getActivities();

    /**
     * Adds an activity to the destination and updates the mapping of activities to destinations.
     *
     * @param activity          The activity to add.
     * @param activityMappings  The mapping of activities to destinations.
     * @throws Exception if the activity is already available at another destination.
     */
    void addActivity(ActivityInterface activity, HashMap<ActivityInterface, String> activityMappings) throws Exception;
}
