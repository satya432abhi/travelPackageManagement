package TravelManager;

import TravelManager.Models.ActivityInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for the StandardPassenger class.
 */
public class StandardPassengerTest {

    private StandardPassenger standardPassenger;
    private ActivityInterface affordableActivity;
    private ActivityInterface expensiveActivity;
    private ActivityInterface fullyBookedActivity;

    @BeforeEach
    void setUp() {
        // Initialize a StandardPassenger object and some Activity objects before each test
        standardPassenger = new StandardPassenger("Satyam Abhishek", 2, 50.0);
        affordableActivity = new Activity("Museum Tour", "Explore history", 15.0, 10);
        expensiveActivity = new Activity("Helicopter Ride", "Aerial adventure", 100.0, 5);
        fullyBookedActivity = new Activity("Scuba Diving", "Underwater exploration", 30.0, 0);
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("Satyam Abhishek", standardPassenger.getPassengerName());
        assertEquals(2, standardPassenger.getPassengerNumber());
        assertEquals(50.0, standardPassenger.getBalance(), 0.001);
        assertNotNull(standardPassenger.getActivitiesEnrolled());
        assertTrue(standardPassenger.getActivitiesEnrolled().isEmpty());
    }

    @Test
    @DisplayName("Test SignUpForActivity - Successful")
    void testSignUpForActivitySuccessful() {
        standardPassenger.signUpForActivity(affordableActivity);

        assertEquals(1, standardPassenger.getActivitiesEnrolled().size());
        assertTrue(standardPassenger.getActivitiesEnrolled().contains(affordableActivity));
        assertEquals(35.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Test SignUpForActivity - Insufficient Balance")
    void testSignUpForActivityInsufficientBalance() {
        standardPassenger.signUpForActivity(expensiveActivity);

        assertTrue(standardPassenger.getActivitiesEnrolled().isEmpty());
        assertEquals(50.0, standardPassenger.getBalance(), 0.001);
    }

    @Test
    @DisplayName("Test SignUpForActivity - No Vacancy")
    void testSignUpForActivityNoVacancy() {
        standardPassenger.signUpForActivity(fullyBookedActivity);

        assertTrue(standardPassenger.getActivitiesEnrolled().isEmpty());
        assertEquals(50.0, standardPassenger.getBalance(), 0.001);
    }
}
