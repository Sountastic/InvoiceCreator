package javafx.invoicesys.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
//    private String login;

    private String userFirstName;
    private String userLastName;
    private String userCompanyName;
    private String userNip;
    private String userAddress;
    private String userCity;
    private String userEmail;

    //    @OneToMany
//    private List<Invoice> invoiceList;
//(Long id, String userLogin,
    public User(String userFirstName, String userLastName, String userCompanyName,
                String userNip, String userAddress, String userCity, String userEmail) {
//        this.id = id;
//        this.login = userLogin;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCompanyName = userCompanyName;
        this.userNip = userNip;
        this.userAddress = userAddress;
        this.userCity = userCity;
        this.userEmail = userEmail;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //    public List<Invoice> getInvoiceList() {
//        return invoiceList;
//    }
//
//    public void setInvoiceList(List<Invoice> invoiceList) {
//        this.invoiceList = invoiceList;
//    }

    @Override
    public String toString() {
        return "User{" +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userCompanyName='" + userCompanyName + '\'' +
                ", userNip='" + userNip + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public String getUserFirstName() {
        return userFirstName;
    }

}