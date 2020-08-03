package com.altimetrik.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altimetrik.busbooking.beans.BookingDetails;
import com.altimetrik.busbooking.beans.BusDetails;
import com.altimetrik.busbooking.beans.BusSearch;
import com.altimetrik.busbooking.beans.Seat;
import com.altimetrik.busbooking.dao.DataManager;

@Service
public class BookingService {
	
	@Autowired
	DataManager dataManager;

	public List<BusDetails> search(BusSearch busSearch) {
		List<BusDetails> busDetailsList = new ArrayList<BusDetails>();
		busDetailsList = dataManager.searchBus(busSearch);
		return busDetailsList;
	}

	public List<Seat> seatDetails(int busNumber) {
		// TODO Auto-generated method stub
		return dataManager.seatDetails(busNumber);
	}

	public String bookSeats(BookingDetails bookingDetails) {
		List<Seat> seats = bookingDetails.getSeats();
		for (Seat seat : seats) {
			dataManager.bookSeat(seat,bookingDetails);
		}
		String bookingId =  dataManager.addBooking(bookingDetails);
		return "Booking Success, BookingID:"+bookingId;
	}

	@Transactional(rollbackFor= {DataAccessException.class})
	public boolean checkNLock(BookingDetails bookingDetails) {
		List<Seat> seats = bookingDetails.getSeats();
		for (Seat seat : seats) {
			boolean status = dataManager.preBook(seat, bookingDetails);
			if(!status) {
				return false;
			}
		}
		return true;
	}


}
