package javafx.invoicesys.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String userFirstName;
    private String userLastName;
    private String userCompanyName;
    private String userNip;
    private String userAddress;
    private String userCity;
    private String userEmail;

    @OneToMany
    private List<Invoice> invoiceList;

    @Override
    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", userFirstName='" + userFirstName + '\'' +
//                ", userLastName='" + userLastName + '\'' +
//                ", userCompanyName='" + userCompanyName + '\'' +
//                '}';
        return userCompanyName;
    }
}
