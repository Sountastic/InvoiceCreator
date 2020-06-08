package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.invoicesys.InvoicePdf;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.ProductRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javafx.invoicesys.entity.Invoice.builder;

@SpringBootApplication
public class Main extends Application {
    private ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);

        CustomersRepository customersRepository = springContext.getBean(CustomersRepository.class);
        UserRepository userRepository = springContext.getBean(UserRepository.class);
        ProductRepository productRepository = springContext.getBean(ProductRepository.class);
        InvoiceRepository invoiceRepository = springContext.getBean(InvoiceRepository.class);

        Customer customer = Customer.builder()
                .customerFirstName("Shrek")
                .customerLastName("Wonderful")
                .customerAddress("Here 12")
                .customerCity("Krakow")
                .customerCompanyName("fhk")
                .customerEmail("foo@bar.com")
                .customerNip("111")
                .build();
        customersRepository.save(customer);

        User user = User.builder()
                .userAddress("lalal")
                .userCity("Katowice")
                .userCompanyName("kakak")
                .userEmail("nopw@nopw.pl")
                .userFirstName("John")
                .userLastName("Snow")
                .userNip("3333")
                .build();
        userRepository.save(user);

        final List<Product> products = new ArrayList<>();
        products.add(Product.builder().description("paprika").price(1.0).build());
        products.add(Product.builder().description("cotton").price(10.0).build());
        products.add(Product.builder().description("drugs").price(12.0).build());
        products.add(Product.builder().description("pizza").price(3.0).build());
        productRepository.saveAll(products);

        Invoice invoice = builder()
                .id(7L)
                .date(LocalDate.now())
                .dueDate(LocalDate.of(2020, 06, 25))
                .user(user)
                .customer(customer)
                .total(350.00)
                .build();
        invoiceRepository.save(invoice);
//
//        InvoicePdf ip = new InvoicePdf();
//        ip.getDataFromRepositoryById(7L);
//        ip.createPdf();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLMainInvoiceApp.fxml"));
        loader.setControllerFactory(springContext::getBean);
        Parent root = loader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root));
//        Scene scene = new Scene(root);
        primaryStage.show();

    }
}
