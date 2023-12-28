package TravelManager;

import java.util.ArrayList;
import java.util.List;

import TravelManager.Models.ActivityInterface;
import TravelManager.Models.PassengerInterface;

/**
 * Represents a Standard class passenger with basic features.
 */
public class StandardPassenger implements PassengerInterface{
	private String passengerName;
	private int passengerNumber;
	private double balance;
	private List<ActivityInterface>activities;
	
	/**
     * Constructs a StandardPassenger object with the specified parameters.
     *
     * @param passengerName   The name of the passenger.
     * @param passengerNumber The unique identifier for the passenger.
     * @param balance The initial balance with the passenger
     */
	public StandardPassenger(final String passengerName,final int passengerNumber,final double balance) {
		this.passengerName = passengerName;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
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
	
	public double getBalance() {
		return balance;
	}
	
	/**
     * Signs up the StandardPassenger for a specific activity.
     *
     * @param activity The activity to sign up for.
     */
	@Override
	public void signUpForActivity(ActivityInterface activity) {
		if (balance >= activity.getActivityCost()&& activity.canSignUpPassenger()) {
            balance -= activity.getActivityCost();
            activities.add(activity);
            System.out.println(passengerName + " (Passenger :" + passengerNumber + ") signed up for activity: " + activity.getActivityName());
        } else {
            System.out.println(passengerName + " (Passenger :" + passengerNumber + ") does not have sufficient balance for activity: " + activity.getActivityName());
        }	
	}
	
}
