package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.invoicesys.service.CustomerService;
import javafx.invoicesys.service.UserService;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLShowDataController implements Initializable {

    private UserRepository userRepository;
    private CustomersRepository customersRepository;

    public FXMLShowDataController(UserRepository userRepository, CustomersRepository customersRepository) {
        this.userRepository = userRepository;
        this.customersRepository = customersRepository;
    }

    @FXML
    private TableView<User> users_table;
    @FXML
    private TableColumn<User, Long> user_id;
    @FXML
    private TableColumn<User, String> user_name;
    @FXML
    private TableColumn<User, String> user_lastname;
    @FXML
    private TableColumn<User, String> user_company;
    @FXML
    private TableColumn<User, String> user_nip;
    @FXML
    private TableColumn<User, String> user_address;
    @FXML
    private TableColumn<User, String> user_city;
    @FXML
    private TableColumn<User, String> user_email;


    @FXML
    private TableView<Customer> clients_table;
    @FXML
    private TableColumn<Customer, Long> cust_id;
    @FXML
    private TableColumn<Customer, String> cust_name;
    @FXML
    private TableColumn<Customer, String> cust_lastname;
    @FXML
    private TableColumn<Customer, String> cust_company;
    @FXML
    private TableColumn<Customer, String> cust_nip;
    @FXML
    private TableColumn<Customer, String> cust_address;
    @FXML
    private TableColumn<Customer, String> cust_city;
    @FXML
    private TableColumn<Customer, String> cust_email;


    ObservableList<User> usersoblist = FXCollections.observableArrayList();
    ObservableList<Customer> customersoblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usersoblist.addAll(userRepository.findAll());

        user_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        user_name.setCellValueFactory(new PropertyValueFactory<>("userFirstName"));
        user_lastname.setCellValueFactory(new PropertyValueFactory<>("userLastName"));
        user_company.setCellValueFactory(new PropertyValueFactory<>("userCompanyName"));
        user_nip.setCellValueFactory(new PropertyValueFactory<>("userNip"));
        user_address.setCellValueFactory(new PropertyValueFactory<>("userAddress"));
        user_city.setCellValueFactory(new PropertyValueFactory<>("userCity"));
        user_email.setCellValueFactory(new PropertyValueFactory<>("userEmail"));

        users_table.setItems(usersoblist);


        customersoblist.addAll(customersRepository.findAll());

        cust_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cust_name.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        cust_lastname.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
        cust_company.setCellValueFactory(new PropertyValueFactory<>("customerCompanyName"));
        cust_nip.setCellValueFactory(new PropertyValueFactory<>("customerNip"));
        cust_address.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        cust_city.setCellValueFactory(new PropertyValueFactory<>("customerCity"));
        cust_email.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

        clients_table.setItems(customersoblist);
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

}
