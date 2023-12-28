package TravelManager;

import TravelManager.Models.ActivityInterface;

/**
 * Represents an activity that can be part of a travel package.
 */
public class Activity implements ActivityInterface{
	private String activityName;
    private String activityDescription;
    private double activityCost;
    private int activityCapacity;
    
    /**
     * Constructs an Activity object with the specified parameters.
     *
     * @param activityName        The name of the activity.
     * @param activityDescription The description of the activity.
     * @param activityCost        The cost of the activity.
     * @param activityCapacity    The capacity or available slots for the activity.
     */
    public Activity(final String activityName,final String activityDescription,
    		final double activityCost,final int activityCapacity) {
    	this.activityName = activityName;
    	this.activityDescription = activityDescription;
    	this.activityCost =  activityCost;
    	this.activityCapacity = activityCapacity;
    }
    
	@Override
	public String getActivityName() {
		return activityName;
	}

	@Override
	public String getActivityDescription() {
		return activityDescription;
	}

	@Override
	public double getActivityCost() {
		return activityCost;
	}

	@Override
	public int getActivityCapacity() {
		return activityCapacity;
	}

	@Override
	public boolean canSignUpPassenger() {
		if(activityCapacity > 0) {
			activityCapacity--;
			return true;
		}
		return false;
	}


}
