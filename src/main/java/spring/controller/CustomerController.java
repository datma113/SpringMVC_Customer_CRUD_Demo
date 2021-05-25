package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.entity.Customer;
import spring.services.CustomerDao;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/customer-save-form")
	public String showCustomerForm(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "customer-save-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerDao.saveCustomer(customer);
		return "redirect:/customer/";
	}
	
	@GetMapping("/customer-list")
	public String showListCustomer(Model model) {
		List<Customer> list = customerDao.getAllCustomer();
		model.addAttribute("customers", list);
		return "customer-list";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId")int id, Model model) {
		Customer c = customerDao.getCustomerById(id);
		model.addAttribute("customer", c);
		return "customer-save-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int id) {
		customerDao.deleteCustomer(id);
		return "redirect:/customer/";
	}
}
