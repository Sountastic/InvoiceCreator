package javafx.invoicesys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    //    private User userData;
//    private Customer customerData;
    private String productDescription;
    private int quantity;
    private double price;
    private double tax;
    private double total;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
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
        this.total = price * (tax / 100) * quantity;

    }

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
