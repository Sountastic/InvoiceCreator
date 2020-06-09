package javafx.invoicesys;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.repository.InvoiceRepository;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class InvoicePdf {

    final InvoiceRepository invoiceRepository;

    private static String FILE = "C:/JavaProjects/MyProjects/InvoiceSysVer3/sample3.pdf";

    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18,
            Font.BOLD);
    private static Font regFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16,
            Font.NORMAL);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
            Font.BOLD);

    public InvoicePdf(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createPdf(Invoice invoice) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(createTable(invoice));
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Invoice");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
    }

    private void addContent(Document document) {
    }

    private static PdfPTable createTable(Invoice invoice) {
        PdfPTable table = new PdfPTable(5);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Product description"));
//        cell.setColspan(5);
        table.addCell(cell);
//        table.addCell(new PdfPCell(new Phrase("Product description")));
        table.addCell(new PdfPCell(new Phrase("Quantity")));
        table.addCell(new PdfPCell(new Phrase("Price")));
        table.addCell(new PdfPCell(new Phrase("Tax")));
        table.addCell(new PdfPCell(new Phrase("Total")));

        cell = new PdfPCell(new Phrase(invoice.getProducts().toString()));
        cell.setRowspan(2);
        table.addCell(cell);

//        table.addCell();
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell(Double.toString(invoice.getTotal()));
        return table;
    }

//    private static PdfPTable createTable(Section subCatPart) throws BadElementException {
//        PdfPTable table = new PdfPTable(10);
//        subCatPart.add(table);
//    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
