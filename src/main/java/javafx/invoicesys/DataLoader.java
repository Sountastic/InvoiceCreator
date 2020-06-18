package javafx.invoicesys;

import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader {

    private final UserRepository userRepository;
    private final CustomersRepository customersRepository;
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final InvoiceProductRepository invoiceProductRepository;

    public DataLoader(UserRepository userRepository, CustomersRepository customersRepository,
                      InvoiceRepository invoiceRepository, ProductRepository productRepository,
                      InvoiceProductRepository invoiceProductRepository) {
        this.userRepository = userRepository;
        this.customersRepository = customersRepository;
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
        this.invoiceProductRepository = invoiceProductRepository;
    }

    @PostConstruct
    public void loadData() {


        Customer customer = Customer.builder()
                .customerFirstName("Rod")
                .customerLastName("Wonderful")
                .customerAddress("Here 12")
                .customerCity("Krakow")
                .customerCompanyName("Foo")
                .customerEmail("foo@bar.com")
                .customerNip("123")
                .build();
        customersRepository.saveAndFlush(customer);

        User user = User.builder()
                .userAddress("lalal")
                .userCity("Katowice")
                .userCompanyName("Kakak")
                .userEmail("nopw@nopw.pl")
                .userFirstName("John")
                .userLastName("Snow")
                .userNip("345")
                .build();
        userRepository.saveAndFlush(user);

        final List<Product> products = new ArrayList<>();
        products.add(Product.builder().description("paprika").price(1.0).build());
        products.add(Product.builder().description("cotton").price(10.0).build());
        products.add(Product.builder().description("drugs").price(12.0).build());
        products.add(Product.builder().description("pizza").price(3.0).build());
        productRepository.saveAll(products);

        Invoice invoice = Invoice.builder()
                .id(7L)
                .date(LocalDate.now())
                .dueDate(LocalDate.of(2020, 06, 25))
                .user(user)
                .customer(customer)
                .total(350.00)
                .build();
        invoiceRepository.saveAndFlush(invoice);
    }

    @PreDestroy
    public void removeData() {

        userRepository.deleteAll();
        customersRepository.deleteAll();
        invoiceRepository.deleteAll();
        productRepository.deleteAll();
        invoiceProductRepository.deleteAll();

    }

}
