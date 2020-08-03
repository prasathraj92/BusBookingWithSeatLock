package com.altimetrik.busbooking.beans;

/**
 * @author Prasath
 *
 */
public class BusSearch {
	
	private String source;
	private String destination;
	private String travelDate;
	private String returnDate;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "BusSearch [source=" + source + ", destination=" + destination + ", travelDate=" + travelDate
				+ ", returnDate=" + returnDate + "]";
	}
	

}
