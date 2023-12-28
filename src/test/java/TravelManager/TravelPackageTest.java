package TravelManager;

import TravelManager.Models.DestinationInterface;
import TravelManager.Models.PassengerInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests for the Travel Package class.
 */
public class TravelPackageTest {

    private TravelPackage travelPackage;
    private DestinationInterface destination1;
    private DestinationInterface destination2;
    private PassengerInterface passenger1;
    private PassengerInterface passenger2;
    private PassengerInterface passenger3;

    @BeforeEach
    void setUp() {
        // Initialize a TravelPackage object and related objects before each test
        destination1 = new Destination("City Tour");
        destination2 = new Destination("Mountain Hiking");
        List<DestinationInterface> itinerary = List.of(destination1, destination2);
        travelPackage = new TravelPackage("Adventure Package", 2, itinerary);

        // Initialize passengers
        passenger1 = new StandardPassenger("Alice", 1, 100.0);
        passenger2 = new GoldPassenger("Bob", 2, 150.0);
        passenger3 = new PremiumPassenger("Charlie", 3);
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("Adventure Package", travelPackage.getPackageName());
        assertEquals(2, travelPackage.getPassengerCapacity());
        assertEquals(2, travelPackage.getItinerary().size());
        assertEquals(0, travelPackage.getPassengers().size());
    }

    @Test
    @DisplayName("Test AddPassenger - Successful")
    void testAddPassengerSuccessful() {
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        assertEquals(2, travelPackage.getPassengers().size());
        assertTrue(travelPackage.getPassengers().contains(passenger1));
        assertTrue(travelPackage.getPassengers().contains(passenger2));
    }

    @Test
    @DisplayName("Test AddPassenger - Full Capacity")
    void testAddPassengerFullCapacity() {
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
     // Attempt to add more passengers than the capacity
        travelPackage.addPassenger(passenger3); 

        assertEquals(2, travelPackage.getPassengers().size());
        assertFalse(travelPackage.getPassengers().contains(passenger3));
    }
}
