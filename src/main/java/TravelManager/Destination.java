package TravelManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import TravelManager.Models.ActivityInterface;
import TravelManager.Models.DestinationInterface;


/**
 * Represents a destination that can be part of a travel package.
 */
public class Destination implements DestinationInterface{
	private String destinationName;
	private List<ActivityInterface> activities;
	
	 /**
     * Constructs a Destination object with the specified name.
     *
     * @param destinationName The name of the destination.
     */
	public Destination(final String destinationName) {
		this.destinationName = destinationName;
		this.activities = new ArrayList<>();
	}
	
	@Override
	public String getDestinationName() {
		return destinationName;
	}

	@Override
	public List<ActivityInterface> getActivities() {
		return activities;
	}
	
	/**
     * Adds an activity to the destination and updates the activity mappings.
     *
     * @param activity          The activity to be added.
     * @param activityMappings  A mapping of activities to their destinations.
     * @throws Exception if the activity is already available at another destination.
     */
	@Override
	public void addActivity(ActivityInterface activity,HashMap<ActivityInterface,String>activityMappings) throws Exception {
		if(activityMappings.containsKey(activity) == false) {
			activityMappings.put(activity, destinationName);
			activities.add(activity);
		} else {
			throw new Exception("Rule Violation : activity is available at more than one destination");
		}
	}
}
