package com.altimetrik.busbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busbooking.beans.BookingDetails;
import com.altimetrik.busbooking.beans.BusDetails;
import com.altimetrik.busbooking.beans.BusSearch;
import com.altimetrik.busbooking.beans.Seat;
import com.altimetrik.busbooking.service.BookingService;

/**
 * @author Prasath
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@RequestMapping("/search")
	public List<BusDetails> search(@RequestBody BusSearch busSearch) {
		System.out.println(busSearch.toString());
		return bookingService.search(busSearch);
	}
	
	@RequestMapping("/seats")
	public List<Seat> seats(@RequestParam int busNumber) {
		return bookingService.seatDetails(busNumber);
	}
	
	@RequestMapping("/book")
	public String book(@RequestBody BookingDetails bookingDetails) {
		return bookingService.bookSeats(bookingDetails);
	}
	
	@RequestMapping("/checkNlock")
	public boolean checkNLock(@RequestBody BookingDetails bookingDetails) {
		return bookingService.checkNLock(bookingDetails);
	}

}
