package javafx.invoicesys.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.repository.ProductRepository;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class FXMLProductController implements Initializable {
    private final ProductRepository productRepository;

    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productPriceTextField;

    public FXMLProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML
    public void handleSubmitNewProductButton() {
        Product product = Product.builder()
                .description(productNameTextField.getText())
                .price(Double.parseDouble(productPriceTextField.getText()))
                .build();
        productRepository.save(product);
    }

}
