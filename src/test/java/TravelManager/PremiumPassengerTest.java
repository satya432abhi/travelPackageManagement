package TravelManager;

import TravelManager.Models.ActivityInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for the PremiumPassenger class.
 */
public class PremiumPassengerTest {

    private PremiumPassenger premiumPassenger;
    private ActivityInterface activityWithVacancy;
    private ActivityInterface activityWithoutVacancy;

    @BeforeEach
    void setUp() {
        // Initialize a PremiumPassenger object and some Activity objects before each test
        premiumPassenger = new PremiumPassenger("Satyam Abhishek", 1);
        activityWithVacancy = new Activity("Hiking", "Enjoy nature", 20.0, 5);
        activityWithoutVacancy = new Activity("Snorkeling", "Explore underwater life", 30.0, 0);
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("Satyam Abhishek", premiumPassenger.getPassengerName());
        assertEquals(1, premiumPassenger.getPassengerNumber());
        assertNotNull(premiumPassenger.getActivitiesEnrolled());
        assertTrue(premiumPassenger.getActivitiesEnrolled().isEmpty());
    }

    @Test
    @DisplayName("Test SignUpForActivity - Successful")
    void testSignUpForActivitySuccessful() {
        premiumPassenger.signUpForActivity(activityWithVacancy);

        assertEquals(1, premiumPassenger.getActivitiesEnrolled().size());
        assertTrue(premiumPassenger.getActivitiesEnrolled().contains(activityWithVacancy));
    }

    @Test
    @DisplayName("Test SignUpForActivity - No Vacancy")
    void testSignUpForActivityNoVacancy() {
        premiumPassenger.signUpForActivity(activityWithoutVacancy);

        assertTrue(premiumPassenger.getActivitiesEnrolled().isEmpty());
    }
}
