package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.*;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.ProductRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLInvoiceCreatorController implements Initializable {
    private final UserRepository userRepository;
    private final CustomersRepository customersRepository;
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;

    private final ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    private final ObservableList<User> userObservableList = FXCollections.observableArrayList();
    private final ObservableList<Product> productList = FXCollections.observableArrayList();

    private final Invoice.InvoiceBuilder invoiceBuilder = Invoice.builder();
    private Double total = 0.0;

    @FXML
    private DatePicker date;
    @FXML
    private DatePicker dueDate;
    @FXML
    private ChoiceBox<Customer> customerChoice;
    @FXML
    private ChoiceBox<User> userChoice;
    @FXML
    private ChoiceBox<Product> productsChoice;
    @FXML
    private TextField qtyTextField;
    @FXML
    private TextField taxTextField;

    public FXMLInvoiceCreatorController(UserRepository userRepository, CustomersRepository customersRepository, InvoiceRepository invoiceRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.customersRepository = customersRepository;
        this.invoiceRepository = invoiceRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerObservableList.addAll(customersRepository.findAll());
        customerChoice.setItems(customerObservableList);

        userObservableList.addAll(userRepository.findAll());
        userChoice.setItems(userObservableList);

        productList.addAll(productRepository.findAll());
        productsChoice.setItems(productList);
    }

    @FXML
    private void handleAddProductToInvoiceBtn() {
        Product product = productsChoice.getValue();
        Long quantity =  Long.parseLong(qtyTextField.getText());
        double tax = Double.parseDouble(taxTextField.getText());

        InvoiceProduct invoiceProduct = InvoiceProduct.builder()
                .product(product)
                .quantity(quantity)
                .tax(tax)
                .totalPrice(product.countPrice(quantity, tax))
                .build();

        invoiceBuilder.product(invoiceProduct);
        total += invoiceProduct.getTotalPrice();
    }

//TO DO: move to ShowDataController

    public void handleDownloadButton() {
//        InvoicePdf invPdf = new InvoicePdf(this);
//        InvoicePdf.createPdf();
    }

    public void handleSubmitInvDataButton() {
        Invoice invoice = Invoice.builder()
                .customer(customerChoice.getValue())
                .user(userChoice.getValue())
                .date(date.getValue())
                .dueDate(dueDate.getValue())
                .total(total)
                .build();
        invoiceRepository.save(invoice);
    }
}
