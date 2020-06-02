package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.invoicesys.entity.InvoicePdf;
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
//        launch(args);
//        InvoicePdf ip = new InvoicePdf();
//        ip.createPdf();
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
    }
}
