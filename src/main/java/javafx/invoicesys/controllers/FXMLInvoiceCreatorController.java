package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.invoicesys.service.InvoiceService;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class FXMLInvoiceCreatorController implements Initializable {
    private UserRepository userRepository;
    private CustomersRepository customersRepository;
    private InvoiceRepository invoiceRepository;
    private LocalDate invDate;
    private LocalDate dueInvDate;
    private String productDescription;
    private int qty;
    private double price;
    private int tax;
    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    private ObservableList<User> userObservableList = FXCollections.observableArrayList();
//    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @Autowired
    private InvoiceService invoiceService;

    @FXML
    private DatePicker date;
    @FXML
    private DatePicker dueDate;
    @FXML
    private ChoiceBox<Customer> customerChoice;
    @FXML
    private ChoiceBox<User> userChoice;
    @FXML
    private TextField descrTextField;
    @FXML
    private TextField qtyTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField taxTextField;

    public FXMLInvoiceCreatorController(InvoiceRepository invoiceRepository, CustomersRepository customersRepository,
                                        UserRepository userRepository) {
        this.invoiceRepository = invoiceRepository;
        this.customersRepository = customersRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerObservableList.addAll(customersRepository.findAll());
        customerChoice.setItems(customerObservableList);

        userObservableList.addAll(userRepository.findAll());
        userChoice.setItems(userObservableList);
    }

    @FXML
    private void handleAddProductToInvoiceBtn() {
        productDescription = descrTextField.getText();
        qty = Integer.parseInt(qtyTextField.getText());
        price = Double.parseDouble(priceTextField.getText());
        tax = Integer.parseInt(taxTextField.getText());

    }

//TO DO: move to ShowDataController

    public void handleDownloadButton() {
//        InvoicePdf invPdf = new InvoicePdf(this);
//        InvoicePdf.createPdf();
    }

    public void handleSubmitInvDataButton() {
        Invoice invoice = new Invoice(date.getValue(), dueDate.getValue(), customerChoice.getValue(), userChoice.getValue(),
                productDescription, qty, price, tax);
        System.out.println(invoice);
        invoiceRepository.save(invoice);
    }
}
