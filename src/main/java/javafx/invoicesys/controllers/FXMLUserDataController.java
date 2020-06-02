package javafx.invoicesys.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.invoicesys.service.CustomerService;
import javafx.invoicesys.service.UserService;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@Setter
@Component
public class FXMLUserDataController implements Initializable {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    public FXMLUserDataController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @FXML
    private TextField userFirstNameTextField;
    @FXML
    private TextField userLastNameTextField;
    @FXML
    private TextField userNipTextField;
    @FXML
    private TextField userCompanyNameTextField;
    @FXML
    private TextField userAddressTextField;
    @FXML
    private TextField userCityTextField;
    @FXML
    private TextField userEmailTextField;
    @FXML
    private Button submitUserDataBtn;
    @FXML
    private Button exitBtn;

    @FXML
    private void handleSubmitUserDataButton() {
        String userFirstName = userFirstNameTextField.getText();
        String userLastName = userLastNameTextField.getText();
        String userCompanyName = userCompanyNameTextField.getText();
        String userNip = userNipTextField.getText();
        String userAddress = userAddressTextField.getText();
        String userCity = userCityTextField.getText();
        String userEmail = userEmailTextField.getText();

        User user1 = new User(userFirstName, userLastName, userCompanyName, userNip,
                userAddress, userCity, userEmail);
        userRepository.save(user1);
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
