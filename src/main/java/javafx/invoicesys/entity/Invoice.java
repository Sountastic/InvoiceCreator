package javafx.invoicesys.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "invoices")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;
    private LocalDate dueDate;
    private double total;

    @OneToMany
    @Singular
    private List<InvoiceProduct> products;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

}
