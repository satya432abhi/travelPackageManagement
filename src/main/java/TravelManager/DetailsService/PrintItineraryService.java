package TravelManager.DetailsService;

import TravelManager.Models.ActivityInterface;
import TravelManager.Models.DestinationInterface;
import TravelManager.Models.TravelPackageInterface;

/**
 * Service class for printing the itinerary of a travel package.
 */
public class PrintItineraryService {
	 /**
     * Prints the itinerary of a travel package, including destination names
     * and details of the activities available at each destination.
     *
     * @param adventurePackage The travel package for which the itinerary is to be printed.
     */
	public static void printItinerary(TravelPackageInterface adventurePackage) {
        System.out.println("Itinerary for " + adventurePackage.getPackageName() + ":");
        for (DestinationInterface destination : adventurePackage.getItinerary()) {
            System.out.println(destination.getDestinationName() + " - Activities:");
            for (ActivityInterface activity : destination.getActivities()) {
                System.out.println("  - " + activity.getActivityName() + ": "
                        + "Cost: $" + activity.getActivityCost() + ", "
                        + "Capacity: " + activity.getActivityCapacity() + ", "
                        + "Description: " + activity.getActivityDescription());
            }
        }
    }
}
