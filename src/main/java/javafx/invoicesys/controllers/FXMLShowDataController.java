package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class FXMLShowDataController implements Initializable {
    private UserRepository userRepository;
    private CustomersRepository customersRepository;
    private InvoiceRepository invoiceRepository;

    public FXMLShowDataController(UserRepository userRepository, CustomersRepository customersRepository,
                                  InvoiceRepository invoiceRepository) {
        this.userRepository = userRepository;
        this.customersRepository = customersRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User, Long> userId;
    @FXML
    private TableColumn<User, String> userName;
    @FXML
    private TableColumn<User, String> userLastname;
    @FXML
    private TableColumn<User, String> userCompany;
    @FXML
    private TableColumn<User, String> userNip;
    @FXML
    private TableColumn<User, String> userAddress;
    @FXML
    private TableColumn<User, String> userCity;
    @FXML
    private TableColumn<User, String> userEmail;


    @FXML
    private TableView<Customer> clientsTable;
    @FXML
    private TableColumn<Customer, Long> custId;
    @FXML
    private TableColumn<Customer, String> custName;
    @FXML
    private TableColumn<Customer, String> custLastname;
    @FXML
    private TableColumn<Customer, String> custCompany;
    @FXML
    private TableColumn<Customer, String> custNip;
    @FXML
    private TableColumn<Customer, String> custAddress;
    @FXML
    private TableColumn<Customer, String> custCity;
    @FXML
    private TableColumn<Customer, String> custEmail;


    @FXML
    private TableView<Invoice> invoicesTable;
    @FXML
    private TableColumn<Invoice, Long> invId;
    @FXML
    private TableColumn<Invoice, LocalDate> invDate;
    @FXML
    private TableColumn<Invoice, LocalDate> invDueDate;
    @FXML
    private TableColumn<Invoice, Customer> invCustId;
    @FXML
    private TableColumn<Invoice, User> invUserId;
    @FXML
    private TableColumn<Invoice, String> productDescr;
    @FXML
    private TableColumn<Invoice, Integer> qty;
    @FXML
    private TableColumn<Invoice, Double> price;
    @FXML
    private TableColumn<Invoice, Double> tax;
    @FXML
    private TableColumn<Invoice, Double> total;


    ObservableList<User> usersoblist = FXCollections.observableArrayList();
    ObservableList<Customer> customersoblist = FXCollections.observableArrayList();
    ObservableList<Invoice> invoiceobList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usersoblist.addAll(userRepository.findAll());

        userId.setCellValueFactory(new PropertyValueFactory<>("id"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userFirstName"));
        userLastname.setCellValueFactory(new PropertyValueFactory<>("userLastName"));
        userCompany.setCellValueFactory(new PropertyValueFactory<>("userCompanyName"));
        userNip.setCellValueFactory(new PropertyValueFactory<>("userNip"));
        userAddress.setCellValueFactory(new PropertyValueFactory<>("userAddress"));
        userCity.setCellValueFactory(new PropertyValueFactory<>("userCity"));
        userEmail.setCellValueFactory(new PropertyValueFactory<>("userEmail"));

        usersTable.setItems(usersoblist);


        customersoblist.addAll(customersRepository.findAll());

        custId.setCellValueFactory(new PropertyValueFactory<>("id"));
        custName.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        custLastname.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
        custCompany.setCellValueFactory(new PropertyValueFactory<>("customerCompanyName"));
        custNip.setCellValueFactory(new PropertyValueFactory<>("customerNip"));
        custAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        custCity.setCellValueFactory(new PropertyValueFactory<>("customerCity"));
        custEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

        clientsTable.setItems(customersoblist);


        invoiceobList.addAll(invoiceRepository.findAll());

        invId.setCellValueFactory(new PropertyValueFactory<>("id"));
        invDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        invDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        invUserId.setCellValueFactory(new PropertyValueFactory<>("user"));
        invCustId.setCellValueFactory(new PropertyValueFactory<>("customer"));
        productDescr.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        qty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tax.setCellValueFactory(new PropertyValueFactory<>("tax"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        invoicesTable.setItems(invoiceobList);

    }
}
