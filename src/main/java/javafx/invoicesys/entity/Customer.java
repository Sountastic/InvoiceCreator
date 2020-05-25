package javafx.invoicesys.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne
//    private User user;


    private String customerFirstName;
    private String customerLastName;
    private String customerCompanyName;
    private String customerNip;
    private String customerAddress;
    private String customerCity;
    private String customerEmail;

    public Customer(String customerFirstName, String customerLastName, String customerCompanyName,
                    String customerNip, String customerAddress, String customerCity, String customerEmail) {
//        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerCompanyName = customerCompanyName;
        this.customerNip = customerNip;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerEmail = customerEmail;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerCompanyName='" + customerCompanyName + '\'' +
                ", customerNip='" + customerNip + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public String getCustomerNip() {
        return customerNip;
    }

    public void setCustomerNip(String customerNip) {
        this.customerNip = customerNip;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
