package com.app.FlightAdmin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.FlightAdmin.Constants.ResponseMessage;
import com.app.FlightAdmin.Model.Airline;
import com.app.FlightAdmin.Service.AirlineService;
import com.app.FlightAdmin.Util.ResponseMessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping(value = { "/airlines" })
@SuppressWarnings("static-access")
public class AirlineController {

	@Autowired
	public ResponseMessageUtil responseUtil;

	@Autowired
	public ResponseMessage message;

	@Autowired
	public AirlineService airlineService;

	@ApiOperation(value = "Ping", notes = "Ping Url")
	@GetMapping(value = "/ping")
	public String test() {
		return "haiii";
	}

	@ApiOperation(value = "Save Airlines", notes = "Add airline with flight and departure Details")
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveAirline(@RequestBody Airline airline) {
		try {
			this.airlineService.saveAirline(airline);
			return new ResponseEntity<>(message.CREATED, HttpStatus.OK);
		} catch (Exception e) {
			return this.responseUtil.errorResponse(e, message.SERVER_ERROR);
		}
	}

	@ApiOperation(value = "ListAll Airlines", notes = "Fetch all airline Details")
	@PostMapping(value = "/fetch")
	public ResponseEntity<Object> fetchAllAirlines() {
		try {
			List<Airline> res = this.airlineService.fetchAllAirlines();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return this.responseUtil.errorResponse(e, message.SERVER_ERROR);
		}
	}
}
