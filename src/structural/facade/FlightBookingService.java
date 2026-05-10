package structural.facade;

import java.util.UUID;

/**
 * Role: Subsystem service
 * Handles flight reservations as part of the trip.
 * Invoked by TripPlannerFacade ... not directly used by clients.
 */
public class FlightBookingService {

    /**
     * Book a flight for the given trip request
     */
    public String bookFlight(TripRequest tripRequest) {
        // Extract details from the trip request
        String origin = tripRequest.origin();
        String destination = tripRequest.destination();
        String departureDate = tripRequest.departure().toString();
        String returnDate = tripRequest.returnDate().toString();
        int guests = tripRequest.guests();

        //Simulate flight booking
        System.out.println(
                "[Flight] Booking "
                + origin + " => " + destination
                + " | Departure: "  + departureDate
                + " | Return: "  + returnDate
                + " | Guests: "  + guests
        );

        return "FL-" + UUID.randomUUID();
    }

}