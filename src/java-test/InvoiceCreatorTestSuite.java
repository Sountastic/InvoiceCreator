import javafx.invoicesys.InvoicePdf;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.User;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceCreatorTestSuite {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomersRepository customersRepository;


    @Test
    public void testPdfCreateMethod() {

    }

}
