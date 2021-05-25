package spring.services;

import java.util.List;

import spring.entity.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public void saveCustomer(Customer c);
	public void deleteCustomer(int id);

}
