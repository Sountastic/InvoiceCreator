package javafx.invoicesys.repository;

import javafx.invoicesys.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceProductsRepository extends JpaRepository<InvoiceProduct, Long> {
}
