package javafx.invoicesys.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "InvoiceID", unique = true)
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
