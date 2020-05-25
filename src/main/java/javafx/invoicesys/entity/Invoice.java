package javafx.invoicesys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private Date dueDate;
    private String productDescription;
    private int quantity;
    private double price;
    private int tax;
    private double total;


    @ManyToOne
    private User user;

    @ManyToOne
    private Customer customer;

    public Invoice(Date date, Date dueDate, Customer customer, User user, String productDescription, int quantity,
                   double price, int tax) {

        this.date = date;
        this.dueDate = dueDate;
        this.customer = customer;
        this.user = user;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.total = price * tax * quantity;

    }

    public Invoice() {
    }
}
