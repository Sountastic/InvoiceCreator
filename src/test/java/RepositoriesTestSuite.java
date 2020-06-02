import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoriesTestSuite {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomersRepository customersRepository;

    @Test
    public void checkInvoiceRepository() {
        //Given
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now(), customersRepository.getOne(1L), userRepository.getOne(3L),
                "test", 1, 100, 8);
        //When
        invoiceRepository.save(invoice);
        System.out.println(invoice);
        Long id = invoice.getId();
        //Then
        Assert.assertTrue(invoiceRepository.existsById(id));
        //CleanUp
        invoiceRepository.deleteById(id);
    }
}
