package javafx.invoicesys.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private double price;

    public Double countPrice(Long quantity, Double tax) {
        double priceWithoutTax = price * quantity;
        return priceWithoutTax + (priceWithoutTax * tax/100);

    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
//                ", price=" + price +
                '}';
    }
}
