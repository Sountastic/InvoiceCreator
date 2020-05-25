package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.InvoicePdf;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.invoicesys.service.CustomerService;
import javafx.invoicesys.service.InvoiceService;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLInvoiceCreatorController implements Initializable {

    private CustomersRepository customersRepository;
    private InvoiceRepository invoiceRepository;

    private UserRepository userRepository;
    private InvoicePdf invoicePdf;

    public FXMLInvoiceCreatorController(InvoiceRepository invoiceRepository, CustomersRepository customersRepository,
                                        UserRepository userRepository, InvoicePdf invoicePdf) {
        this.invoiceRepository = invoiceRepository;
        this.customersRepository = customersRepository;
        this.userRepository = userRepository;
        this.invoicePdf = invoicePdf;
    }

    ObservableList<String> customerChoiceBox = FXCollections.observableArrayList();
    ObservableList<String> userChoiceBox = FXCollections.observableArrayList();


    @FXML
    private DatePicker date;
    @FXML
    private DatePicker dueDate;
    @FXML
    private ChoiceBox customerChoice;
    @FXML
    private ChoiceBox userChoice;
    @FXML
    private TextField descrTextField;
    @FXML
    private TextField qtyTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField taxTextField;
    @FXML
    private Button submitInvoiceDataBtn;
    @FXML
    private Button addProductToInvoiceBtn;
    @FXML
    private Button downloadBtn;

    private String choosenCustomer;
    private String choosenUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int n = 0; n < customersRepository.findAll().size(); n++) {
            customerChoiceBox.addAll(String.valueOf(customersRepository.findAll().get(n)));
        }
        customerChoice.setItems(customerChoiceBox);
        for (int m = 0; m < userRepository.findAll().size(); m++) {
            userChoiceBox.addAll(String.valueOf(userRepository.findAll().get(m)));
        }
        userChoice.setItems(userChoiceBox);
    }

    @FXML
    private void handleSubmitInvDataButton() {

    }

    @FXML
    private void handleAddProductToInvoiceBtn() {
        String productDescription = descrTextField.getText();
        int qty = Integer.parseInt(qtyTextField.getText());
        double price = Double.parseDouble(priceTextField.getText());
        int tax = Integer.parseInt(taxTextField.getText());

    }

    @Autowired
    private InvoiceService invoiceService;


    public void handleDownloadButton() {
//        InvoicePdf invPdf = new InvoicePdf(this);
//        InvoicePdf.createPdf();
    }

    public void handleChooseCustomer() {
        choosenCustomer = (String) customerChoice.getValue();
    }

    public void handleChooseUser() {
        choosenUser = (String) userChoice.getValue();
    }

    public String getChoosenCustomer() {
        return choosenCustomer;
    }

    public String getChoosenUser() {
        return choosenUser;
    }


}
