package com.paypal.bfs.test.bookingserv.transform;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.model.AddressModel;
import com.paypal.bfs.test.bookingserv.repository.model.BookingModel;


public class DBModelToJsonObjectTransformer {
    private DBModelToJsonObjectTransformer() {
    }

    public static Booking transformToBookingJson(BookingModel bookingModel){
        Booking booking = new Booking();
        booking.setFirstName(bookingModel.getFirstName());
        booking.setLastName(bookingModel.getLastName());
        booking.setDateOfBirth(bookingModel.getDateOfBirth());
        booking.setAddress(transformAddress(bookingModel.getAddressModel()));
        booking.setCheckOut(bookingModel.getCheckOut());
        booking.setCheckIn(bookingModel.getCheckIn());
        booking.setDeposit(bookingModel.getDeposit());
        booking.setTotalPrice(bookingModel.getTotalPrice());
        return booking;
    }

    public static Address transformAddress(AddressModel addressModel){
        Address address = new Address();
        address.setLine1(addressModel.getLine1());
        address.setLine2(addressModel.getLine2());
        address.setCity(addressModel.getCity());
        address.setState(addressModel.getState());
        address.setCountry(addressModel.getCountry());
        address.setZipcode(addressModel.getZipcode());
        return address;
    }
}
