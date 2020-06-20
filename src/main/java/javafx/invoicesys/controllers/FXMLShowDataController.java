package javafx.invoicesys.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.invoicesys.InvoicePdf;
import javafx.invoicesys.entity.Customer;
import javafx.invoicesys.entity.Invoice;
import javafx.invoicesys.entity.User;
import javafx.invoicesys.repository.CustomersRepository;
import javafx.invoicesys.repository.InvoiceRepository;
import javafx.invoicesys.repository.UserRepository;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
public class FXMLShowDataController implements Initializable {

    final ApplicationContext context;

    private final UserRepository userRepository;
    private final CustomersRepository customersRepository;
    private final InvoiceRepository invoiceRepository;


    public FXMLShowDataController(ApplicationContext context, UserRepository userRepository, CustomersRepository customersRepository,
                                  InvoiceRepository invoiceRepository) {
        this.context = context;
        this.userRepository = userRepository;
        this.customersRepository = customersRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User, Long> userId;
    @FXML
    private TableColumn<User, String> userName;
    @FXML
    private TableColumn<User, String> userLastname;
    @FXML
    private TableColumn<User, String> userCompany;
    @FXML
    private TableColumn<User, String> userNip;
    @FXML
    private TableColumn<User, String> userAddress;
    @FXML
    private TableColumn<User, String> userCity;
    @FXML
    private TableColumn<User, String> userEmail;


    @FXML
    private TableView<Customer> clientsTable;
    @FXML
    private TableColumn<Customer, Long> custId;
    @FXML
    private TableColumn<Customer, String> custName;
    @FXML
    private TableColumn<Customer, String> custLastname;
    @FXML
    private TableColumn<Customer, String> custCompany;
    @FXML
    private TableColumn<Customer, String> custNip;
    @FXML
    private TableColumn<Customer, String> custAddress;
    @FXML
    private TableColumn<Customer, String> custCity;
    @FXML
    private TableColumn<Customer, String> custEmail;


    @FXML
    private TableView<Invoice> invoicesTable;
    @FXML
    private TableColumn<Invoice, Long> invId;
    @FXML
    private TableColumn<Invoice, LocalDate> invDate;
    @FXML
    private TableColumn<Invoice, LocalDate> invDueDate;
    @FXML
    private TableColumn<Invoice, Customer> invCustId;
    @FXML
    private TableColumn<Invoice, User> invUserId;
    @FXML
    private TableColumn<Invoice, Double> total;

    ObservableList<User> userObservableList = FXCollections.observableArrayList();
    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    ObservableList<Invoice> invoiceProductObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userObservableList.clear();
        customerObservableList.clear();
        invoiceProductObservableList.clear();

        userObservableList.addAll(userRepository.findAll());

        userId.setCellValueFactory(new PropertyValueFactory<>("id"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userFirstName"));
        userLastname.setCellValueFactory(new PropertyValueFactory<>("userLastName"));
        userCompany.setCellValueFactory(new PropertyValueFactory<>("userCompanyName"));
        userNip.setCellValueFactory(new PropertyValueFactory<>("userNip"));
        userAddress.setCellValueFactory(new PropertyValueFactory<>("userAddress"));
        userCity.setCellValueFactory(new PropertyValueFactory<>("userCity"));
        userEmail.setCellValueFactory(new PropertyValueFactory<>("userEmail"));

        usersTable.setItems(userObservableList);


        customerObservableList.addAll(customersRepository.findAll());

        custId.setCellValueFactory(new PropertyValueFactory<>("id"));
        custName.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
        custLastname.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
        custCompany.setCellValueFactory(new PropertyValueFactory<>("customerCompanyName"));
        custNip.setCellValueFactory(new PropertyValueFactory<>("customerNip"));
        custAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        custCity.setCellValueFactory(new PropertyValueFactory<>("customerCity"));
        custEmail.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));

        clientsTable.setItems(customerObservableList);


        invoiceProductObservableList.addAll(invoiceRepository.findAll());

        invId.setCellValueFactory(new PropertyValueFactory<>("id"));
        invDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        invDueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        invUserId.setCellValueFactory(new PropertyValueFactory<>("user"));
        invCustId.setCellValueFactory(new PropertyValueFactory<>("customer"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        invoicesTable.setItems(invoiceProductObservableList);

    }

    public void handleDownloadPdfButton() {
        Invoice invoice = invoicesTable.getSelectionModel().getSelectedItem();
        InvoicePdf invPdf = new InvoicePdf();
        invPdf.createPdf(invoice, "C:/JavaProjects/MyProjects/InvoiceSysVer3/sample3.pdf");
//        invPdf.createPdf(invoice, System.getProperty("user.dir"));
        showViewAndWait("PopUpWindowPdf.fxml");
    }


    public void showViewAndWait(String path) {
        final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(path));
        loader.setControllerFactory(context::getBean);
        try {
            AnchorPane pane = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
