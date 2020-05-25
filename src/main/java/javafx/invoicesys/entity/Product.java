package javafx.invoicesys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private double price;

    public Product(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

}
