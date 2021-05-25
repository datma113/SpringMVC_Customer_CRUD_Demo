package spring.services;

import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.Customer;

@Service
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public List<Customer> getAllCustomer() {
		List<Customer> list = null;
		Session s = factory.getCurrentSession();
		NativeQuery<Customer> query = s.createNativeQuery("select * from customer", Customer.class);
		list = query.getResultList();
		return list;
	}

	@Transactional
	public void saveCustomer(Customer c) {
		Session s = factory.getCurrentSession();
		s.saveOrUpdate(c);
	}
	
	@Transactional
	public void deleteCustomer(int id) {
		Session s = factory.getCurrentSession();
		Customer c = s.get(Customer.class, id);
		s.delete(c);
	}
	
	@Transactional
	public Customer getCustomerById(int id) {
		Session s = factory.getCurrentSession();
		Customer c = s.get(Customer.class, id);
		return c;
	}

}
