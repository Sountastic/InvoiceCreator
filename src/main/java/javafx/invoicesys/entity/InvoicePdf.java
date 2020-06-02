package javafx.invoicesys.entity;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12,
            Font.NORMAL);

    public InvoicePdf(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createPdf() {
        try {
//            invoiceRepository.findFirstById()
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            document.add(createTable());
//            addMetaData(document);
//            addTitlePage(document);
//            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
//    private static void addMetaData(Document document) {
//        document.addTitle("Invoice");
//    }
//
//    private static void addTitlePage(Document document)
//            throws DocumentException {
//        Paragraph preface = new Paragraph();
//        // We add one empty line
//        addEmptyLine(preface, 1);
//        // Lets write a big header
//        preface.add(new Paragraph("INVOICE", catFont));
//        addEmptyLine(preface, 8);
//        document.add(preface);
//    }
//
//    private static void addContent(Document document) throws DocumentException {
//        Anchor anchor = new Anchor("INVOICE", catFont);
//        anchor.setName("INVOICE");
//
//        // Second parameter is the number of the chapter
//        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
//
//        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
//        Section subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Hello"));
//        subPara = new Paragraph("Subcategory 2", subFont);
//        subCatPart = catPart.addSection(subPara);
//        subCatPart.add(new Paragraph("Paragraph 1"));
//        subCatPart.add(new Paragraph("Paragraph 2"));
////        subCatPart.add(new Paragraph(invController.getChoosenCustomer()));
//
//        createTable(subCatPart);
//
//        document.add(catPart);
//
//    }
//
    private static PdfPTable createTable() {
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
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
//        table.addCell();
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }
//    private static PdfPTable createTable(Section subCatPart) throws BadElementException {
//        PdfPTable table = new PdfPTable(10);
//
//        // t.setBorderColor(BaseColor.GRAY);
//        // t.setPadding(4);
//        // t.setSpacing(4);
//        // t.setBorderWidth(1);
//
//        PdfPCell c1 = new PdfPCell(new Phrase("Invoice id"));
//        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c1);
//
//        PdfPCell c2 = new PdfPCell(new Phrase("Date"));
//        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c2);
//
//        PdfPCell c3 = new PdfPCell(new Phrase("DueDate"));
//        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c3);
//
//        PdfPCell c4 = new PdfPCell(new Phrase("Customer"));
//        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c4);
//
//        PdfPCell c5 = new PdfPCell(new Phrase("Seller"));
//        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c5);
//
//        PdfPCell c6 = new PdfPCell(new Phrase("Product description"));
//        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c6);
//
//        PdfPCell c7 = new PdfPCell(new Phrase("Qty"));
//        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c7);
//
//        PdfPCell c8 = new PdfPCell(new Phrase("Price"));
//        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c8);
//
//        PdfPCell c9 = new PdfPCell(new Phrase("Tax"));
//        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c9);
//
//        PdfPCell c10 = new PdfPCell(new Phrase("Total"));
//        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(c10);
//        table.setHeaderRows(1);
//
//        //TO DO: petla for - tyle wierszy ile produktow plus jeden dodatkowy z suma
//        table.addCell("1.0");
//        table.addCell("1.1");
//        table.addCell("1.2");
//        table.addCell("2.1");
//        table.addCell("2.2");
//        table.addCell("2.3");
//
//        subCatPart.add(table);
//
//    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
