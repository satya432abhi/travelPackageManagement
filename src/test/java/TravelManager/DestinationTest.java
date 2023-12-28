package TravelManager;

import TravelManager.Models.ActivityInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * Tests for the Destination class.
 */
public class DestinationTest {

    private Destination destination;
    private ActivityInterface activity1;
    
    @BeforeEach
    void setUp() {
        // Initialize a Destination object and some Activity objects before each test
        destination = new Destination("Beach Resort");
        activity1 = new Activity("Beach Volleyball", "Play volleyball on the beach", 10.0, 20);
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("Beach Resort", destination.getDestinationName());
        assertNotNull(destination.getActivities());
        assertTrue(destination.getActivities().isEmpty());
    }

    @Test
    @DisplayName("Test Add Activity - Successful")
    void testAddActivitySuccessful() throws Exception {
        HashMap<ActivityInterface, String> activityMappings = new HashMap<>();
        destination.addActivity(activity1, activityMappings);

        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity1));
        assertTrue(activityMappings.containsKey(activity1));
        assertEquals("Beach Resort", activityMappings.get(activity1));
    }

    @Test
    @DisplayName("Test Add Activity - Rule Violation")
    void testAddActivityRuleViolation() {
        HashMap<ActivityInterface, String> activityMappings = new HashMap<>();
        activityMappings.put(activity1, "Beach Resort"); 

        Exception exception = assertThrows(Exception.class, () -> {
            destination.addActivity(activity1, activityMappings);
        });

        assertEquals("Rule Violation : activity is available at more than one destination", exception.getMessage());
        assertTrue(destination.getActivities().isEmpty());
    }
}
