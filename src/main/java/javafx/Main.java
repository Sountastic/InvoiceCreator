package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.invoicesys.InvoicePdf;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
    private ConfigurableApplicationContext springContext;


    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        InvoiceRepository invoiceRepository = springContext.getBean(InvoiceRepository.class);

//        InvoicePdf ip = new InvoicePdf();
//        Invoice invoice = invoiceRepository.findAll().get(0);
//        ip.createPdf(invoice, "C:/JavaProjects/MyProjects/InvoiceSysVer3/sample3.pdf");
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
