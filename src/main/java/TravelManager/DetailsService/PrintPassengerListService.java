package TravelManager.DetailsService;

import TravelManager.Models.PassengerInterface;
import TravelManager.Models.TravelPackageInterface;

/**
 * Service class for printing the passenger list of a travel package.
 */
public class PrintPassengerListService {
	/**
     * Prints the passenger list of a travel package, including package details
     * and information about each enrolled passenger.
     *
     * @param adventurePackage The travel package for which the passenger list is to be printed.
     */
	public static void printPassengerList(TravelPackageInterface adventurePackage) {
        System.out.println("Passenger List for " + adventurePackage.getPackageName() + ":");
        System.out.println("  - Package Name: " + adventurePackage.getPackageName());
        System.out.println("  - Passenger Capacity: " + adventurePackage.getPassengerCapacity());
        System.out.println("  - Passengers Enrolled: " + adventurePackage.getPassengers().size());
        System.out.println("  - Details of each passenger:");
        for (PassengerInterface passenger : adventurePackage.getPassengers()) {
            System.out.println("    - Name: " + passenger.getPassengerName() +
                    ", Number: " + passenger.getPassengerNumber());
        }
    }
}
