package javafx.invoicesys.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLMainWindowController implements Initializable {

    final ApplicationContext context;

    public FXMLMainWindowController(ApplicationContext context) {
        this.context = context;
    }

    @FXML
    public void handleCreateInvoiceButton() {
        showViewAndWait("FXMLInvoiceCreator.fxml");
    }

    @FXML
    public void handleAddCustomerButton() {
        showViewAndWait("FXMLCompanyDetails.fxml");
    }

    @FXML
    public void handleAddProductButton() {
        showViewAndWait("FXMLProduct.fxml");
    }

    @FXML
    public void handleAddUserDataButton() {
        showViewAndWait("FXMLUserData.fxml");
    }

    public void handleShowDataButton() {
        showViewAndWait("FXMLShowData.fxml");
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

    private void showViewAndWait(String path) {
        final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(path));
        loader.setControllerFactory(context::getBean);
        try {
            AnchorPane pane = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
