package com.app.FlightAdmin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.FlightAdmin.Constants.ResponseMessage;
import com.app.FlightAdmin.Dao.DiscountDao;
import com.app.FlightAdmin.Model.Discount;
import com.app.FlightAdmin.Service.DiscountService;
import com.app.FlightAdmin.Util.ResponseMessageUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = { "/discount" })
@SuppressWarnings("static-access")
public class DiscountController {

	@Autowired
	public ResponseMessageUtil responseUtil;

	@Autowired
	public ResponseMessage message;

	@Autowired
	public DiscountService discountService;

	@Autowired
	public DiscountDao dao;

	@ApiOperation(value = "Save discount", notes = "Add discount with code and price")
	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveDiscount(@RequestBody Discount discount) {
		try {
			this.discountService.saveDiscount(discount);
			return new ResponseEntity<>(message.CREATED, HttpStatus.OK);
		} catch (Exception e) {
			return this.responseUtil.errorResponse(e, message.SERVER_ERROR);
		}
	}

	@ApiOperation(value = "ListAll Discounts", notes = "Fetch all discount Details")
	@PostMapping(value = "/getAll")
	public ResponseEntity<Object> fetchAllFlights() {
		try {
			List<Discount> res = this.discountService.fetchAllDiscounts();
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return this.responseUtil.errorResponse(e, message.SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Delete discount", notes = "Fetch discount details by id and delete Object")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		boolean isRemoved = dao.delete(this.dao.findById(id));
		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
