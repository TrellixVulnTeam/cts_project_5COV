package com.app.FlightAdmin.Dao;

import java.util.List;

import com.app.FlightAdmin.Model.Discount;

public interface DiscountDao {

	public void saveDiscount(Discount discount);

	public List<Discount> fetchAllDiscounts();

	public boolean delete(Discount obj);

	public Discount findById(Long id);

}
