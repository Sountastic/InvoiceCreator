package javafx.invoicesys.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "UserID", unique = true)
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

    public User(String userFirstName, String userLastName, String userCompanyName,
                String userNip, String userAddress, String userCity, String userEmail) {
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

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserCompanyName() {
        return userCompanyName;
    }

    public void setUserCompanyName(String userCompanyName) {
        this.userCompanyName = userCompanyName;
    }

    public String getUserNip() {
        return userNip;
    }

    public void setUserNip(String userNip) {
        this.userNip = userNip;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

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


}
