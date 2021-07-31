package com.paypal.bfs.test.bookingserv.transform;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.model.AddressModel;
import com.paypal.bfs.test.bookingserv.repository.model.BookingModel;


public class JsonObjectToDBModelTransformer {

    private JsonObjectToDBModelTransformer() {
    }

    public static BookingModel transformToBookingDBEntity(Booking booking){
        BookingModel bookingModel = new BookingModel();
        bookingModel.setFirstName(booking.getFirstName());
        bookingModel.setLastName(booking.getLastName());
        bookingModel.setDateOfBirth(booking.getDateOfBirth());
        bookingModel.setAddressModel(transformAddressEntity(booking.getAddress()));
        bookingModel.setCheckOut(booking.getCheckOut());
        bookingModel.setCheckIn(booking.getCheckIn());
        bookingModel.setDeposit(booking.getDeposit());
        bookingModel.setTotalPrice(booking.getTotalPrice());
        return bookingModel;
    }
    public static AddressModel transformAddressEntity(Address address){
        AddressModel addressModel = new AddressModel();
        addressModel.setCity(address.getCity());
        addressModel.setCountry(address.getCountry());
        addressModel.setState(address.getState());
        addressModel.setZipcode(address.getZipcode());
        addressModel.setLine1(address.getLine1());
        addressModel.setLine2(address.getLine2());
        return addressModel;
    }
}
