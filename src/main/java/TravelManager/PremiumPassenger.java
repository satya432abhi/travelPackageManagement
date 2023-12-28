package TravelManager;

import java.util.ArrayList;
import java.util.List;

import TravelManager.Models.ActivityInterface;
import TravelManager.Models.PassengerInterface;

/**
 * Represents a Premium class passenger with basic features.
 */
public class PremiumPassenger implements PassengerInterface{
	private String passengerName;
	private int passengerNumber;
	private List<ActivityInterface>activities;
	
	 /**
     * Constructs a PremiumPassenger object with the specified parameters.
     *
     * @param passengerName   The name of the passenger.
     * @param passengerNumber The unique identifier for the passenger.
     */
	public PremiumPassenger(final String passengerName,final int passengerNumber) {
		this.passengerName = passengerName;
		this.passengerNumber = passengerNumber;
		this.activities = new ArrayList<>();
	}

	@Override
	public String getPassengerName() {
		return passengerName;
	}

	@Override
	public int getPassengerNumber() {
		return passengerNumber;
	}
	
	@Override
	public List<ActivityInterface> getActivitiesEnrolled() {
		return activities;
	}
	
	/**
     * Signs up the PremiumPassenger for a specific activity.
     *
     * @param activity The activity to sign up for.
     */
	@Override
	public void signUpForActivity(ActivityInterface activity) {
		if(activity.canSignUpPassenger()) {
			activities.add(activity);
			System.out.println(passengerName + " (Passenger :" + passengerNumber + ") signed up for activity: " + activity.getActivityName());
		} else {
			System.out.println(passengerName + " (Passenger :" + passengerNumber + ") could not sign up because of no vacancy for activity:" + activity.getActivityName());
		}
	}
}
