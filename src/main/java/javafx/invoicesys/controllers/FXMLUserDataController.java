package javafx.invoicesys.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.UserRepository;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLUserDataController implements Initializable {
    private final UserRepository userRepository;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML
    private void handleSubmitUserDataButton() {
        User user = User.builder()
                .userFirstName(userFirstNameTextField.getText())
                .userLastName(userLastNameTextField.getText())
                .userEmail(userEmailTextField.getText())
                .userNip(userNipTextField.getText())
                .userCompanyName(userCompanyNameTextField.getText())
                .userCity(userCityTextField.getText())
                .userAddress(userAddressTextField.getText())
                .build();
        userRepository.save(user);
    }

    @FXML
    private void handleExitButtonAction() {
        System.exit(0);
    }

}
