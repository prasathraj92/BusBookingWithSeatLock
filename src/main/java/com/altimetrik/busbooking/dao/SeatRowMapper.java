package com.altimetrik.busbooking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.altimetrik.busbooking.beans.Seat;

public class SeatRowMapper implements RowMapper<Seat> {

	@Override
	public Seat mapRow(ResultSet rs, int arg1) throws SQLException {
		Seat seat = new Seat();
		seat.setBirth(rs.getString("birth"));
		seat.setId(""+rs.getInt("id"));
		seat.setPassangerName(rs.getString("passanger_name"));
		seat.setSeatType(rs.getString("seat_type"));
		seat.setStatus(rs.getString("status"));
		return seat;
	}

}
