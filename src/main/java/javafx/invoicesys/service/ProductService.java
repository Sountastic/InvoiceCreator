package javafx.invoicesys.service;

import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.Product;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.ProductRepository;
import org.hibernate.resource.beans.spi.BeanInstanceProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
