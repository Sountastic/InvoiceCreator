package javafx.invoicesys.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLCustomerDetailsController implements Initializable {
    private final CustomersRepository customersRepository;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML
    private void handleSubmitCustomerDataButton() {
        Customer customer = Customer.builder()
                .customerFirstName(customerFirstNameTextField.getText())
                .customerLastName(customerLastNameTextField.getText())
                .customerEmail(customerEmailTextField.getText())
                .customerNip(customerNipTextField.getText())
                .customerCompanyName(customerCompanyNameTextField.getText())
                .customerCity(customerCityTextField.getText())
                .customerAddress(customerAddressTextField.getText())
                .build();

        customersRepository.save(customer);
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

}
