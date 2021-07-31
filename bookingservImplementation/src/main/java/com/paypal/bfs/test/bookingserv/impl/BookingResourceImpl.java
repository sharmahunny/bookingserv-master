package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.repository.model.BookingModel;
import com.paypal.bfs.test.bookingserv.transform.DBModelToJsonObjectTransformer;
import com.paypal.bfs.test.bookingserv.transform.JsonObjectToDBModelTransformer;
import com.paypal.bfs.test.bookingserv.validator.BookingValidationService;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/bfs/booking")
public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingValidationService bookingValidationService;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @PostMapping("")
    public ResponseEntity<Booking> create(Booking booking) {
        bookingValidationService.validate(booking);
        BookingModel bookingModel = JsonObjectToDBModelTransformer.transformToBookingDBEntity(booking);

        Booking bookingResult = DBModelToJsonObjectTransformer.transformToBookingJson(bookingRepository.save(bookingModel));

        return new ResponseEntity<Booking>(bookingResult,HttpStatus.OK);
    }

    @Override
    @GetMapping("")
    public ResponseEntity<List<Booking>> getAll() {

        List<BookingModel> listFromDb = bookingRepository.getAll();

        List<Booking> resultList = new ArrayList<>();
        for (BookingModel model :  listFromDb){
            Booking booking = DBModelToJsonObjectTransformer.transformToBookingJson(model);
            resultList.add(booking);
        }

        return new ResponseEntity<List<Booking>>(resultList,HttpStatus.OK);
    }


    @ExceptionHandler({BadInputException.class})
    public ResponseEntity<Object> handleException(BadInputException exception) {
        Map<Object, Object> headers = new HashMap<>();
        headers.put("error", exception.getMessage());
        headers.put("status", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }
}
