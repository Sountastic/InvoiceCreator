package javafx.invoicesys.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;
    private LocalDate dueDate;
    private String productDescription;
    private int quantity;
    private double price;
    private double tax;
    private double total;


    @ManyToOne
    private User user;

    @ManyToOne
    private Customer customer;

    public Invoice(LocalDate date, LocalDate dueDate, Customer customerData, User userData, String productDescription, int quantity,
                   double price, double tax) {

        this.date = date;
        this.dueDate = dueDate;
        this.customer = customerData;
        this.user = userData;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.total = price * (tax/100) * quantity;

    }

    public Invoice() {
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", dueDate=" + dueDate +
                ", productDescription='" + productDescription + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", tax=" + tax +
                ", total=" + total +
                ", user=" + user +
                ", customer=" + customer +
                '}';
    }


}
