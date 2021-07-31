package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.model.BookingModel;

import java.util.List;

public interface BookingRepository {

    BookingModel save(BookingModel booking);

    List<BookingModel> getAll();
}
