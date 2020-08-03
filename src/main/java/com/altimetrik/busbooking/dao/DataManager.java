package com.altimetrik.busbooking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.altimetrik.busbooking.beans.BookingDetails;
import com.altimetrik.busbooking.beans.BusDetails;
import com.altimetrik.busbooking.beans.BusSearch;
import com.altimetrik.busbooking.beans.Seat;
import com.altimetrik.busbooking.beans.User;
import com.altimetrik.busbooking.constants.AppConstants;

@Repository
public class DataManager {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String INSERT_USER = "insert into USER(user_name, first_name, last_name, age, email_address, mobile_number, whats_app)"
			+ " values(?, ?, ?, ? ,?, ?, ?)";
	
	private final String UPDATE_USER = "update USER set first_name=?, last_name=?, age=?, email_address=?, mobile_number=?, whats_app=? "
			+ " where user_name=?";
	
	private final String SELECT_USER = "select * from USER where user_name =?";
	
	private final String SELECT_BUS = "select * from BUS_DETAILS where bus_number =?";
	
	private final String INSERT_BUS = "insert into BUS_DETAILS(bus_number, operator_name, departure, arrival_time, duration, price, total_seats, available_seats, source, destination) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String SEARCH_BUS = "select * from BUS_DETAILS where source=? and destination=?  order by price asc";
	
	private final String INSERT_SEAT = "insert into SEAT(seat_type, birth, status, bus_id) values (?, ?, ?, ?)";
	
	private final String SELECT_SEAT = "select * from SEAT where bus_id =?";
	
	private final String UPDATE_SEAT = "update SEAT set passanger_name =? , status=? where bus_id = ? and id=?";
	
	private final String INSERT_PREBOOK = "insert into PRE_BOOKING(bus_number, seat_number, unique_id, user_id, status, passanger_name) "
			+ "values(?, ?, ?, ?, ?, ?)";

	public String insertUser(User user) {
		Object[] data = {user.getUserName(), user.getFirstName(), user.getLastName(), user.getAge(), user.getEmailAddress(), user.getMobileNumber(), user.getWhatsAppEnabled()};
		int result = jdbcTemplate.update(INSERT_USER, data);
		if(result <0) {
			return AppConstants.FAILURE;
		}
		return AppConstants.SUCCESS;
	}
	
	public String updateUser(User user) {
		Object[] data = {user.getFirstName(), user.getLastName(), user.getAge(), user.getEmailAddress(), user.getMobileNumber(), user.getWhatsAppEnabled(), user.getUserName()};
		int result = jdbcTemplate.update(UPDATE_USER, data);
		if(result <0) {
			return AppConstants.FAILURE;
		}
		return AppConstants.SUCCESS;
	}
	
	public User getUser(String userName) {
		User user = null;
		Object[] data = {userName};
		List<User> userList = jdbcTemplate.query(SELECT_USER, data, new RowMapper() {

			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				User user = new User();
				while(arg0.next()) {					
					user.setAge(arg0.getInt("age")); //arg0.getString(columnLabel)
					user.setEmailAddress(arg0.getString("email_address"));
					user.setMobileNumber(arg0.getString("mobile_number"));
					user.setUserName(arg0.getString("user_name"));
				}
				return user;
			}
		});
		user = userList.get(0);
		return user;
	}

	public String addBus(BusDetails busDetail) {
		//Timestamp arrival = new Timestamp(System.currentTimeMillis());
		//Timestamp departure = new Timestamp(System.currentTimeMillis()-2000);
		Object data[] = {busDetail.getBusNumber(), busDetail.getOperatorName(), busDetail.getDeparture(), busDetail.getArrivalTime(),
				busDetail.getDuration(), busDetail.getPrice(), busDetail.getTotalSeats(), busDetail.getAvailableSeats(), busDetail.getSource(), busDetail.getDestination()};
		int result = jdbcTemplate.update(INSERT_BUS, data);
		if(result <0) {
			return AppConstants.FAILURE;
		}
		return AppConstants.SUCCESS;
	}
	
	public BusDetails getBusDetails(String busNumber) {
		BusDetails busDetails = null;
		Object[] data = {busNumber};
		List<BusDetails> busDetailsList = jdbcTemplate.query(SELECT_BUS, data, new BusDetailsMapper());
		busDetails = busDetailsList.get(0);
		return busDetails;
	}

	public List<BusDetails> searchBus(BusSearch busSearch) {
		System.out.println(busSearch.toString());
		Object[] data = {busSearch.getSource(), busSearch.getDestination()};
		List<BusDetails> busDetailsList = jdbcTemplate.query(SEARCH_BUS, data, new BusDetailsMapper());
		return busDetailsList;
	}

	public String addSeat(Seat seat, String busNumber) {
		Object[] data = {seat.getSeatType(), seat.getBirth(), seat.getStatus(), busNumber};
		int result = jdbcTemplate.update(INSERT_SEAT, data);
		if(result <0) {
			return AppConstants.FAILURE;
		}
		return AppConstants.SUCCESS;
	}
	
	public List<Seat> seatDetails(int busNumber) {
		System.out.println(busNumber);
		Object[] data = {busNumber};
		List<Seat> busDetailsList = jdbcTemplate.query(SELECT_SEAT, data, new SeatRowMapper());
		return busDetailsList;
	}
	
	public String bookSeat(Seat seat, BookingDetails details) {
		Object[] data = {seat.getPassangerName(), "Y", details.getBusNumber(), seat.getId()};
		int result = jdbcTemplate.update(UPDATE_SEAT, data);
		if(result <0) {
			return AppConstants.FAILURE;
		}
		return AppConstants.SUCCESS;
	}

	public String addBooking(BookingDetails bookingDetails) {
		// Save into BOOKING_DETAILS table
		return UUID.randomUUID().toString();
		//return String.valueOf(new Random().nextLong());		
	}
	
	public boolean preBook(Seat seat, BookingDetails details) {
		String uniqueId = details.getBusNumber() + "-"+seat.getId();
		//bus_number, seat_number, unique_id, user_id, status, passanger_name
		Object[] data = {details.getBusNumber(), seat.getId(), uniqueId, details.getUserId(), "N", seat.getPassangerName()};
		try {
			int result = jdbcTemplate.update(INSERT_PREBOOK, data);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
