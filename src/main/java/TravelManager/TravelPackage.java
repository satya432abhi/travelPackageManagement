package TravelManager;

import java.util.ArrayList;
import java.util.List;

import TravelManager.Models.DestinationInterface;
import TravelManager.Models.PassengerInterface;
import TravelManager.Models.TravelPackageInterface;

/**
 * Represents a travel package with specified details.
 */
public class TravelPackage implements TravelPackageInterface{
	 private String packageName;
	 private int passengerCapacity;
	 private List<DestinationInterface> itinerary;
	 private List<PassengerInterface> passengers;
	 
	 /**
	  * Constructs a TravelPackage object with the specified parameters.
	  *
	  * @param packageName       The name of the travel package.
	  * @param passengerCapacity The maximum number of passengers the package can accommodate.
	  * @param itinerary         The list of destinations in the travel package itinerary.
	  */
	 public TravelPackage(final String packageName,final int passengerCapacity,
			 final List<DestinationInterface> itinerary) {
		 this.packageName = packageName;
		 this.passengerCapacity = passengerCapacity;
		 this.itinerary = itinerary;
		 this.passengers = new ArrayList<>();
	 }

	@Override
	public String getPackageName() {
		return packageName;
	}

	@Override
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public List<DestinationInterface> getItinerary() {
		return itinerary;
	}

	@Override
	public List<PassengerInterface> getPassengers() {
		return passengers;
	}

	/**
     * Adds a passenger to the travel package if there is capacity.
     *
     * @param passenger The passenger to be added.
     */
	@Override
	public void addPassenger(PassengerInterface passenger) {
		if(passengerCapacity > passengers.size()) {
			passengers.add(passenger);
            System.out.println(passenger.getPassengerName() + " (Passenger #" + passenger.getPassengerNumber() + ") added to " + packageName);
		} else {
			System.out.println("Cannot add more passengers. The travel package is at full capacity.");
		}
	}
}
