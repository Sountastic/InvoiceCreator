package javafx.invoicesys.repository;

import javafx.invoicesys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findFirstByCustomerCompanyName(String customerCompanyName);
    Customer findAllByCustomerCompanyName(String customerCompanyName);
}
