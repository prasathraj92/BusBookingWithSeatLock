package com.altimetrik.busbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busbooking.beans.BusDetails;
import com.altimetrik.busbooking.service.AdminService;

/**
 * @author Prasath
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/addBus")
	public String seats(@RequestBody BusDetails busDetail) {
		return adminService.addBus(busDetail);
	}
	
	@RequestMapping("/addSeat")
	public String seats(@RequestParam String busNumber, @RequestParam int noOfSeats , @RequestParam String seatType, @RequestParam String birth) {
		return adminService.addSeats(busNumber, noOfSeats, seatType, birth);
	}

}
