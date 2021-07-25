package com.app.FlightAdmin.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.FlightAdmin.Dao.DiscountDao;
import com.app.FlightAdmin.Model.Discount;

@Repository
@Transactional
public class DiscountDaoImpl implements DiscountDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveDiscount(Discount discount) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(discount);
	}

	@Override
	public List<Discount> fetchAllDiscounts() {
		try {
			// return
			// sessionFactory.getCurrentSession().createCriteria(Discount.class).list();
			return sessionFactory.getCurrentSession().createQuery("SELECT a FROM Discount a", Discount.class)
					.getResultList();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public boolean delete(Discount obj) {
		try {
			this.sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception ex) {
			System.out.println("Err in discount Deletion :" + ex);
			return false;
		}
	}

	@Override
	public Discount findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Discount obj = (Discount) session.load(Discount.class, id);
		return obj;
	}

}
