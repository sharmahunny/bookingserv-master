package com.paypal.bfs.test.bookingserv.repository.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.repository.model.BookingModel;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component("bookingRepository")
public class BookingRepositoryImpl implements BookingRepository {

    private int id = 0;

    Map<Integer, BookingModel> bookingMap = new HashMap<>();

    @Override
    public BookingModel save(BookingModel booking) {
        int bookingId = ++id;
        booking.setId(bookingId);
        bookingMap.put(bookingId,booking);
        return booking;
    }

    @Override
    public List<BookingModel> getAll() {

        List<BookingModel> list = new ArrayList<>();

        for (BookingModel bok : bookingMap.values()) {
            list.add(bok);
        }
        return list;
    }
}
