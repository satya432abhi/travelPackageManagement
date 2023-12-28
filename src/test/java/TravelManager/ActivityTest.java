package TravelManager;

import TravelManager.Models.ActivityInterface;

/**
 * Tests for the Activity class.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ActivityTest {

    private ActivityInterface activity;

    @BeforeEach
    void setUp() {
        // Initialize an Activity object before each test
        activity = new Activity("Hiking", "Enjoy nature", 20.0, 5);
    }

    @Test
    @DisplayName("Test Activity Getters")
    void testGetters() {
        assertEquals("Hiking", activity.getActivityName());
        assertEquals("Enjoy nature", activity.getActivityDescription());
        assertEquals(20.0, activity.getActivityCost(), 0.001);
        assertEquals(5, activity.getActivityCapacity());
    }

    @Test
    @DisplayName("Test SignUpPassenger - Successful")
    void testSignUpPassengerSuccessful() {
        assertTrue(activity.canSignUpPassenger());
        assertEquals(4, activity.getActivityCapacity());
    }

    @Test
    @DisplayName("Test SignUpPassenger - Failure")
    void testSignUpPassengerFailure() {
        // Use up all available capacity
        assertTrue(activity.canSignUpPassenger());
        assertTrue(activity.canSignUpPassenger());
        assertTrue(activity.canSignUpPassenger());
        assertTrue(activity.canSignUpPassenger());
        assertTrue(activity.canSignUpPassenger());

        // Attempt to sign up one more passenger should fail
        assertFalse(activity.canSignUpPassenger());
        assertEquals(0, activity.getActivityCapacity());
    }
}
