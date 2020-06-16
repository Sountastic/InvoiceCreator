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
        Customer customer = Customer.builder()
                .customerFirstName("Rod")
                .customerLastName("Wonderful")
                .customerAddress("Here 12")
                .customerCity("Krakow")
                .customerCompanyName("Foo")
                .customerEmail("foo@bar.com")
                .customerNip("123")
                .build();

        User user = User.builder()
                .userAddress("lalal")
                .userCity("Katowice")
                .userCompanyName("Kakak")
                .userEmail("nopw@nopw.pl")
                .userFirstName("John")
                .userLastName("Snow")
                .userNip("345")
                .build();

        Invoice invoice = Invoice.builder()
                .id(7L)
                .date(LocalDate.now())
                .dueDate(LocalDate.of(2020, 06, 25))
                .user(user)
                .customer(customer)
                .total(350.00)
                .build();

        InvoicePdf invoicePdf = new InvoicePdf(invoiceRepository);
        invoicePdf.createPdf(invoice);

    }

}
