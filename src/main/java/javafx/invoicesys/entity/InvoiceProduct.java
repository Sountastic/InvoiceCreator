package javafx.invoicesys.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "invoice_products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@ToString
public class InvoiceProduct {

    @Id
    @GeneratedValue
    private Long id;


    private Long quantity;
    private double tax;
    private double totalPrice;

    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
