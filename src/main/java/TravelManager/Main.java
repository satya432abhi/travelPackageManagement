package TravelManager;

import TravelManager.Models.DestinationInterface;
import TravelManager.DetailsService.PrintAvailableActivitiesService;
import TravelManager.DetailsService.PrintIndividualPassengerDetailsService;
import TravelManager.DetailsService.PrintItineraryService;
import TravelManager.DetailsService.PrintPassengerListService;
import TravelManager.Models.ActivityInterface;
import TravelManager.Models.TravelPackageInterface;
import TravelManager.Models.PassengerInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){
    	
    	try {
        // Create destinations
        DestinationInterface cityTour = new Destination("City Tour");
        DestinationInterface mountainHiking = new Destination("Mountain Hiking");

        // Create activities for destinations
        ActivityInterface cityTourActivity = new Activity("Sightseeing", "Explore the city", 20.0, 5);
        ActivityInterface museumActivity = new Activity("Museum", "Explore the city Museum", 25.0, 5);
        ActivityInterface hikingActivity = new Activity("Mountain Hiking", "Hike in the mountains", 30.0, 10);
        
        HashMap<ActivityInterface,String>activityMappings = new HashMap<>();
        
        // Add activities to destinations
        cityTour.addActivity(cityTourActivity,activityMappings);
        cityTour.addActivity(museumActivity, activityMappings);;
        mountainHiking.addActivity(hikingActivity,activityMappings);

        // Create itinerary with destinations
        List<DestinationInterface> itinerary = new ArrayList<>();
        itinerary.add(cityTour);
        itinerary.add(mountainHiking);

        // Create a travel package
        TravelPackageInterface adventurePackage = new TravelPackage("Adventure Package", 2, itinerary);

        // Create passengers
        PassengerInterface satyam = new StandardPassenger("Satyam", 1, 100.0);
        PassengerInterface rohit = new GoldPassenger("Rohit", 2, 150.0);
        PassengerInterface shivam = new PremiumPassenger("Shivam", 3);

        // Add passengers to the travel package
        adventurePackage.addPassenger(satyam);
        adventurePackage.addPassenger(rohit);
        // Attempt to add more passengers than the capacity
        adventurePackage.addPassenger(shivam); 
            
        // Sign up passenger for Activity
        satyam.signUpForActivity(cityTourActivity);
        rohit.signUpForActivity(hikingActivity);
        shivam.signUpForActivity(museumActivity);

        // Display information
        PrintItineraryService.printItinerary(adventurePackage);
        PrintPassengerListService.printPassengerList(adventurePackage);

        // Display details of an individual passenger
        PrintIndividualPassengerDetailsService.printIndividualPassengerDetails(adventurePackage, satyam, activityMappings);

        // Display available activities
        PrintAvailableActivitiesService.printAvailableActivities(adventurePackage);
    	} catch(Exception e) {
    		System.out.println("Exception occured :" + e.getMessage());
    		e.printStackTrace();
    	}
    }
}
