package TravelManager.DetailsService;

import TravelManager.Models.ActivityInterface;
import TravelManager.Models.DestinationInterface;
import TravelManager.Models.TravelPackageInterface;

/**
 * Service class for printing available activities in a travel package.
 */
public class PrintAvailableActivitiesService {
	/**
     * Prints activities with available spaces for a given travel package.
     *
     * @param adventurePackage The travel package for which available activities are to be printed.
     */
	public static void printAvailableActivities(TravelPackageInterface adventurePackage) {
        System.out.println("Activities with Available Spaces for " + adventurePackage.getPackageName() + ":");
        for (DestinationInterface destination : adventurePackage.getItinerary()) {
            for (ActivityInterface activity : destination.getActivities()) {
                if (activity.getActivityCapacity() > 0) {
                    System.out.println("  - " + activity.getActivityName() +
                            " (Destination: " + destination.getDestinationName() + ")" +
                            ", Spaces Available: " + activity.getActivityCapacity());
                }
            }
        }
    }
}
