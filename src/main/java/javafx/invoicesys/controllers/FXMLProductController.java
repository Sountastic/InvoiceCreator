package javafx.invoicesys.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.repository.ProductRepository;
import javafx.invoicesys.service.CustomerService;
import javafx.invoicesys.service.ProductService;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLProductController implements Initializable {
    private ProductRepository productRepository;

    public FXMLProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productPriceTextField;
    @FXML
    private Button submitNewProductBtn;

    @FXML
    private void handleSubmitNewProductButton() {
        String productName = productNameTextField.getText();
        double productPrice = Double.parseDouble(productPriceTextField.getText());
        Product product = new Product(productName, productPrice);
        productRepository.save(product);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Autowired
    private ProductService productService;
}
