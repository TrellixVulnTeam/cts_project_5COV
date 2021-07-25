package com.app.FlightAdmin.Service;

import java.util.List;

import com.app.FlightAdmin.Model.Airline;
import com.app.FlightAdmin.Model.Flight;

public interface DepartureService {

	public void saveFlight(Flight flight);

	public List<Airline> fetchAllFlights();

}
