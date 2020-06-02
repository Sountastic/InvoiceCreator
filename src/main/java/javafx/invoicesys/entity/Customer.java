package javafx.invoicesys.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "clients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String customerFirstName;
    private String customerLastName;
    private String customerCompanyName;
    private String customerNip;
    private String customerAddress;
    private String customerCity;
    private String customerEmail;

    @OneToMany
    private List<Invoice> invoiceList = new LinkedList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerCompanyName='" + customerCompanyName + '\'' +
                '}';
    }
}
