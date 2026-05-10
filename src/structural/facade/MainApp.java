package structural.facade;

import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {

        // Create the Facade (provides a simple interface to multiple subsystems)
        TripPlannerFacade tripPlannerFacade = new TripPlannerFacade();

        // Define trip dates: 6 months from now, 4-day duration
        LocalDate departureDate = LocalDate.now().plusMonths(6);
        LocalDate returnDate = departureDate.plusDays(4);

        // Create a trip request object (input date for facade)
        TripRequest tripRequest =  new TripRequest(
                "BR",
                "USA",
                departureDate,
                returnDate,
                1,
                "1234"
        );

        // Use the facade to book a complete trip
        TripConfirmation tripConfirmation = tripPlannerFacade.bookCompleteTrip(tripRequest);

        System.out.println();

        // Display confirmation details
        System.out.println("=== Trip Confirmation ===");
        System.out.println("Trip ID       :  " + tripConfirmation.tripId());
        System.out.println("Flight         :   " + tripConfirmation.flightRef());
        System.out.println("Hotel          :   " + tripConfirmation.hotelRef());
        System.out.println("Payment    :  " + tripConfirmation.paymentRef());

    }
}