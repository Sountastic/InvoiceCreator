package javafx.invoicesys.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.service.CustomerService;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLCustomerDetailsController implements Initializable {

    @Autowired
    private CustomerService customerService;

    private CustomersRepository customersRepository;

    public FXMLCustomerDetailsController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @FXML
    private TextField customerFirstNameTextField;
    @FXML
    private TextField customerLastNameTextField;
    @FXML
    private TextField customerNipTextField;
    @FXML
    private TextField customerCompanyNameTextField;
    @FXML
    private TextField customerAddressTextField;
    @FXML
    private TextField customerCityTextField;
    @FXML
    private TextField customerEmailTextField;
    @FXML
    private Button submitCustomerDataBtn;
    @FXML
    private Button exitBtn;

    @FXML
    private void handleSubmitCustomerDataButton() {
        String customerFirstName = customerFirstNameTextField.getText();
        String customerLastName = customerLastNameTextField.getText();
        String customerCompanyName = customerCompanyNameTextField.getText();
        String customerNip = customerNipTextField.getText();
        String customerAddress = customerAddressTextField.getText();
        String customerCity = customerCityTextField.getText();
        String customerEmail = customerEmailTextField.getText();

        Customer customer = new Customer(customerFirstName, customerLastName, customerCompanyName,
                customerNip, customerAddress, customerCity, customerEmail);
        customersRepository.save(customer);

    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }



}
