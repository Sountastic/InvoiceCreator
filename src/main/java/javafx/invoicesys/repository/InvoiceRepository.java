package javafx.invoicesys.repository;

import javafx.invoicesys.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findFirstById(Long id);
}
