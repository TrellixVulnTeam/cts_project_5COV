package com.app.FlightAdmin.Dao;

import java.util.List;

import com.app.FlightAdmin.Model.Airline;

public interface AirlineDao {

	public void saveAirline(Airline airline);

	public List<Airline> getAllAirlines();

	public Airline findById(Long airlineId);

	public boolean delete(Airline airlineId);
}
