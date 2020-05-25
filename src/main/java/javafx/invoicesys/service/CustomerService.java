package javafx.invoicesys.service;


import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomersRepository customerRepository;

    public CustomerService(CustomersRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
