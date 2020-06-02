package javafx.invoicesys.repository;

import javafx.invoicesys.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
@Transactional
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findFirstById(Long id);
}
