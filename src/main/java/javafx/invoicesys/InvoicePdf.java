package javafx.invoicesys;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.User;
import javafx.scene.text.TextAlignment;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

@Component
public class InvoicePdf {

    private static String FILE = "C:/JavaProjects/MyProjects/InvoiceSysVer3/sample3.pdf";

    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 28,
            Font.BOLD);
    private static Font regFont = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16,
            Font.NORMAL);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
            Font.BOLD);


    public void createPdf(Invoice invoice) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(addTitle("INVOICE no." + invoice.getId().toString()));
            document.add(Chunk.NEWLINE);
            document.add(addDates(invoice));
            document.add(Chunk.NEWLINE);
            document.add(addSellerAndBuyerData(invoice));
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            document.add(createTable(invoice));
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Paragraph addTitle(String s) {
        Paragraph title = new Paragraph(s);
        title.setFont(catFont);
        title.setAlignment(Element.ALIGN_CENTER);
        return title;
    }

    public static Paragraph addDates(Invoice invoice) {
        String dates = "Invoice date: " + invoice.getDate().toString() + "\nDue date: " + invoice.getDueDate().toString();
        Paragraph datesPar = new Paragraph(dates);
        datesPar.setAlignment(Element.ALIGN_RIGHT);
        return datesPar;
    }

    public PdfPTable addSellerAndBuyerData(Invoice invoice) {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90f);
        PdfPCell cellOne = new PdfPCell(new Paragraph(addUserData(invoice)));
        PdfPCell cellTwo = new PdfPCell(new Paragraph(addCustomerData(invoice)));
        cellOne.setBorder(Rectangle.NO_BORDER);
        cellOne.setLeading(1f, 1.2f);
        cellOne.setPaddingLeft(15);
        cellTwo.setBorder(Rectangle.NO_BORDER);
        cellTwo.setLeading(1f, 1.2f);
        cellTwo.setPaddingLeft(120);
        table.addCell(cellOne);
        table.addCell(cellTwo);
        return table;
    }

    private static Paragraph addUserData(Invoice invoice) {

        User user = invoice.getUser();
        String fullName = user.getUserFirstName() + " " + user.getUserLastName();
        String companyData = user.getUserCompanyName() + " \nNIP: " + user.getUserNip();
        String address = user.getUserAddress() + ", " + user.getUserCity();
        String email = user.getUserEmail();
        String userData = fullName + "\n" + companyData + "\n" + address + "\n" + email;
        Paragraph userPar = new Paragraph(userData);
        userPar.setAlignment(Element.ALIGN_LEFT);
        return userPar;
    }

    private static Paragraph addCustomerData(Invoice invoice) {
        Customer customer = invoice.getCustomer();
        String fullName = customer.getCustomerFirstName() + " " + customer.getCustomerLastName();
        String companyData = customer.getCustomerCompanyName() + " \nNIP: " + customer.getCustomerNip();
        String address = customer.getCustomerAddress() + ", " + customer.getCustomerCity();
        String email = customer.getCustomerEmail();
        String customerData = fullName + "\n" + companyData + "\n" + address + "\n" + email;
        Paragraph customerPar = new Paragraph(customerData);
        customerPar.setAlignment(Element.ALIGN_RIGHT);
        return customerPar;
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
        table.setWidthPercentage(85f);
        table.addCell(new PdfPCell(new Phrase("Product description")));
        table.addCell(new PdfPCell(new Phrase("Quantity")));
        table.addCell(new PdfPCell(new Phrase("Price")));
        table.addCell(new PdfPCell(new Phrase("Tax")));
        table.addCell(new PdfPCell(new Phrase("Total")));
        table.addCell(new PdfPCell(new Phrase("descr1")));
        table.addCell(new PdfPCell(new Phrase("qty")));

        PdfPCell cell = new PdfPCell(new Phrase("price"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        table.addCell(invoice.getCustomer().getCustomerCompanyName());
        table.addCell(String.valueOf(invoice.getTotal()));
        return table;
    }
}
