package javafx.invoicesys.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "invoice_products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    //bez getterow i setterow wlasny setter , adn nad getterem   @transient
}
