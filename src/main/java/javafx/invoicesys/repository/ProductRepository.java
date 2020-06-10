package javafx.invoicesys.repository;

import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Invoice findFirstById(Long id);
}
