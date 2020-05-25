package javafx.invoicesys.service;

import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

}
