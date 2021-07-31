package com.paypal.bfs.test.bookingserv.validator;


import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.commons.ErrorMessages;
import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import org.springframework.stereotype.Service;

@Service
public class BookingValidationService {


    public void validate(Booking booking) {
        if (booking == null)
            throw new BadInputException(ErrorMessages.EMPTY_OR_NULL_BOOKING_OBJECT);
        if (booking.getAddress() == null)
            throw new BadInputException(ErrorMessages.EMPTY_OR_NULL_ADDRESS_OBJECT);
        validateBookingFields(booking);
    }

    private void validateBookingFields(Booking booking) {


    }
}
