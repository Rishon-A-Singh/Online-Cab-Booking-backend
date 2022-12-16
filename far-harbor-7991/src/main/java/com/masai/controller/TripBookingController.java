package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.service.TripBookingService;

@RestController
public class TripBookingController {

	@Autowired
	private TripBookingService tServ;
	
	@PostMapping("/trip")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody TripBooking tripBooking) throws TripBookingException{
		TripBooking insertedTrip = tServ.insertTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(insertedTrip, HttpStatus.CREATED);
	}
	
	@PutMapping("/trip")
	public ResponseEntity<TripBooking> updateTripBookingHandler(@RequestBody TripBooking tripBooking) throws TripBookingException{
		TripBooking updateTrip = tServ.updateTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(updateTrip, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/trip")
	public ResponseEntity<TripBooking> deleteTripBookingHandler(@RequestBody TripBooking tripBooking) throws TripBookingException{
		TripBooking deletedTrip = tServ.deleteTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(deletedTrip, HttpStatus.OK);
	}
	
	public ResponseEntity<List<TripBooking>> viewAllTripCustomers(Integer customerId) throws TripBookingException{
		
	}
	
}
