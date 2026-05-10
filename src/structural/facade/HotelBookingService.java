package structural.facade;

import java.util.UUID;

/**
 * Role: Subsystem service
 * Handles hotel reservations as part of the trip.
 * Invoked by TripPlannerFacade ... not used directly by clients.
 */
public class HotelBookingService {

    /**
     * Book a hotel for the given trip request
     */
    public String bookHotel(TripRequest tripRequest) {
        // Extract details from the trip request
        String destination = tripRequest.destination();
        String checkIn = tripRequest.departure().toString();
        String checkOut = tripRequest.returnDate().toString();
        int guests = tripRequest.guests();

        //Simulate hotel booking
        System.out.println(
                "[Hotel] Booking at "
                        + destination
                        + " | Check-in: "  + checkIn
                        + " | Check-out: "  + checkOut
                        + " | Guests: "  + guests
        );

        return "HT-" + UUID.randomUUID();
    }

}