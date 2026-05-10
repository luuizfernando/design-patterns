package structural.facade;

import java.time.LocalDate;

/**
 * Value object representing a trip booking request
 * Aggregates inputs details
 */
public record TripRequest(
        String origin,
        String destination,
        LocalDate departure,
        LocalDate returnDate,
        int guests,
        String cardLast4
) {}