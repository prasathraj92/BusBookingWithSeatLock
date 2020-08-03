package com.altimetrik.busbooking.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.altimetrik.busbooking.beans.BusDetails;

public class BusDetailsMapper implements RowMapper<BusDetails> {
	
	String DateFormat = "YYYY-MMM-dd HH:MM:SS.SSS";

	@Override
	public BusDetails mapRow(ResultSet arg0, int arg1) throws SQLException {
		BusDetails busDetails = new BusDetails();
		busDetails.setArrivalTime(toTime(arg0.getTimestamp("arrival_time")));
		busDetails.setAvailableSeats(arg0.getInt("available_seats"));
		busDetails.setBusNumber(arg0.getString("bus_number"));
		busDetails.setDeparture(toTime(arg0.getTimestamp("departure")));
		busDetails.setDestination(arg0.getString("destination"));
		busDetails.setDuration(arg0.getInt("duration"));
		busDetails.setOperatorName(arg0.getString("operator_name"));
		busDetails.setPrice(arg0.getInt("price"));
		busDetails.setSource(arg0.getString("source"));
		busDetails.setTotalSeats(arg0.getInt("total_seats"));
		return busDetails;
	}
	
	public String toTime(Timestamp time) {
		Date date = new Date(time.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		return sdf.format(date);
	}

}
