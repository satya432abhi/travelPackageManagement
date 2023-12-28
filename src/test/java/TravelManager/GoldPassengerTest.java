package TravelManager;

import TravelManager.Models.ActivityInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for the GoldPassenger class.
 */
public class GoldPassengerTest {

    private GoldPassenger goldPassenger;
    private ActivityInterface affordableActivity;
    private ActivityInterface expensiveActivity;
    private ActivityInterface fullyBookedActivity;

    @BeforeEach
    void setUp() {
        // Initialize a GoldPassenger object and some Activity objects before each test
        goldPassenger = new GoldPassenger("Satyam Abhishek", 3, 100.0);
        affordableActivity = new Activity("City Tour", "Explore landmarks", 30.0, 10);
        expensiveActivity = new Activity("Hot Air Balloon Ride", "Aerial adventure", 150.0, 5);
        fullyBookedActivity = new Activity("Deep Sea Fishing", "Fishing in deep waters", 40.0, 0);
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("Satyam Abhishek", goldPassenger.getPassengerName());
        assertEquals(3, goldPassenger.getPassengerNumber());
        assertEquals(100.0, goldPassenger.getBalance(), 0.001);
        assertNotNull(goldPassenger.getActivitiesEnrolled());
        assertTrue(goldPassenger.getActivitiesEnrolled().isEmpty());
    }

    @Test
    @DisplayName("Test SignUpForActivity - Successful")
    void testSignUpForActivitySuccessful() {
        goldPassenger.signUpForActivity(affordableActivity);

        assertEquals(1, goldPassenger.getActivitiesEnrolled().size());
        assertTrue(goldPassenger.getActivitiesEnrolled().contains(affordableActivity));
        assertEquals(73.0, goldPassenger.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Test SignUpForActivity - Insufficient Balance")
    void testSignUpForActivityInsufficientBalance() {
        goldPassenger.signUpForActivity(expensiveActivity);

        assertTrue(goldPassenger.getActivitiesEnrolled().isEmpty());
        assertEquals(100.0, goldPassenger.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Test SignUpForActivity - No Vacancy")
    void testSignUpForActivityNoVacancy() {
        goldPassenger.signUpForActivity(fullyBookedActivity);

        assertTrue(goldPassenger.getActivitiesEnrolled().isEmpty());
        assertEquals(100.0, goldPassenger.getBalance(), 0.001);
    }
}
