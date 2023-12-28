package TravelManager.Models;

import java.util.List;

/**
 * The interface representing a travel package. Travel packages have a name, passenger capacity,
 * an itinerary, and a list of passengers. Methods are provided to get package name, passenger
 * capacity, itinerary, passengers, and to add a passenger to the travel package.
 */
public interface TravelPackageInterface {

    /**
     * Gets the name of the travel package.
     *
     * @return The name of the travel package.
     */
    String getPackageName();

    /**
     * Gets the passenger capacity of the travel package.
     *
     * @return The passenger capacity of the travel package.
     */
    int getPassengerCapacity();

    /**
     * Gets the itinerary of the travel package.
     *
     * @return The itinerary of the travel package.
     */
    List<DestinationInterface> getItinerary();

    /**
     * Gets the list of passengers enrolled in the travel package.
     *
     * @return The list of passengers enrolled in the travel package.
     */
    List<PassengerInterface> getPassengers();

    /**
     * Adds a passenger to the travel package.
     *
     * @param passenger The passenger to be added.
     */
    void addPassenger(PassengerInterface passenger);
}
