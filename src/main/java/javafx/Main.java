package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext springContext;

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


    public static void main(String[] args) {
        launch(args);
//        System.out.println("java version: "+System.getProperty("java.version"));
//        System.out.println("javafx.version: " + System.getProperty("javafx.version"));
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
    }

//    @Bean
//    public CommandLineRunner exampleTables(CustomersRepository customersRepository, InvoiceRepository invoiceRepository) {
//        return args -> {
//
//            Customer customer = new Customer("John", "Snow", "Pudliszki",
//                    "74928388", "Warszawska 24", "Białystok", "j.snow@pudliszki.pl");
//
//            customersRepository.save(customer);
////            invoiceRepository.save(new Invoice("John Snow", user));
////            invoiceRepository.save(new Invoice("Any Snow", user));
////            invoiceRepository.save(new Invoice("Mark Snow", user));
//            customersRepository.flush();
//
//            Customer customer2 = customersRepository.findFirstByCustomerCompanyName("Pudliszki");
//            System.out.println(customer2);
//        };
//    }
}
