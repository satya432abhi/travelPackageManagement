package TravelManager.DetailsService;

import java.util.HashMap;

import TravelManager.GoldPassenger;
import TravelManager.StandardPassenger;
import TravelManager.Models.ActivityInterface;
import TravelManager.Models.PassengerInterface;
import TravelManager.Models.TravelPackageInterface;

/**
 * Service class for printing details of an individual passenger.
 */
public class PrintIndividualPassengerDetailsService {
	/**
     * Prints details of an individual passenger including name, number, balance (if applicable),
     * and the list of activities they have signed up for with destination and price details.
     *
     * @param adventurePackage The travel package the passenger is enrolled in.
     * @param passenger        The individual passenger whose details are to be printed.
     * @param activityMappings Mapping of activities to their respective destinations.
     */
	 public static void printIndividualPassengerDetails(TravelPackageInterface adventurePackage, PassengerInterface passenger, 
			 HashMap<ActivityInterface,String> activityMappings) {
	        System.out.println("Details of Passenger " + passenger.getPassengerName() +
	                " (Number: " + passenger.getPassengerNumber() + "):");
	        System.out.println("  - Name: " + passenger.getPassengerName());
	        System.out.println("  - Number: " + passenger.getPassengerNumber());
	        if (passenger instanceof StandardPassenger) {
	            StandardPassenger standardPassenger = (StandardPassenger) passenger;
	            System.out.println("  - Balance: $" + standardPassenger.getBalance());
	        } else if(passenger instanceof GoldPassenger) {
	        	GoldPassenger goldPassenger = (GoldPassenger) passenger;
	            System.out.println("  - Balance: $" + goldPassenger.getBalance());
	        }
	        System.out.println("  - List of Activities Enrolled:");
	        for (ActivityInterface activity : passenger.getActivitiesEnrolled()) {
	            System.out.println("    - " + activity.getActivityName() +
	                    " (Destination: " + activityMappings.get(activity) + ")" +
	                    ", Price Paid: $" + activity.getActivityCost());
	        }
	    }
}
