package com.altimetrik.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.busbooking.beans.BusDetails;
import com.altimetrik.busbooking.beans.Seat;
import com.altimetrik.busbooking.dao.DataManager;

@Service
public class AdminService {
	
	@Autowired
	DataManager dataManager;

	public String addBus(BusDetails busDetail) {
		String response = dataManager.addBus(busDetail);
		return response;
	}

	public String addSeats(String busNumber, int noOfSeats, String seatType, String birth) {
		//List<Seat> seatList = new ArrayList<>();
		for(int i=1; i<=noOfSeats;i++) {
			Seat seat = new Seat();
			seat.setSeatType(seatType);
			seat.setId(""+i);
			seat.setStatus("N");
			seat.setBirth(birth);
			//seatList.add(seat);
			dataManager.addSeat(seat, busNumber);
		}
		return "Success";
	}

}
