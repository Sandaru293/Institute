package controller;

import bo.BOFactory;
import bo.custom.PaymentBO;
import dto.PaymentDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {
    PaymentBO paymentBO = (PaymentBO) BOFactory.getInstance().getBO(BOFactory.BOType.PAYMENT);

    @FXML
    private TableView<PaymentDTO> tblPayment;

    @FXML
    private TableColumn<PaymentDTO, String> clmPayId;

    @FXML
    private TableColumn<PaymentDTO, String> clmCouId;

    @FXML
    private TableColumn<PaymentDTO, String> clmRegId;

    @FXML
    private TableColumn<PaymentDTO, String> clmStuId;

    public void getallPaymentDetail(){
        try {
            ObservableList<PaymentDTO> list = paymentBO.getAllPayment();
            tblPayment.getItems().clear();
            tblPayment.setItems(list);

            clmPayId.setCellValueFactory(new PropertyValueFactory<PaymentDTO, String>("payId"));
            clmCouId.setCellValueFactory(new PropertyValueFactory<PaymentDTO, String>("couId"));
            clmRegId.setCellValueFactory(new PropertyValueFactory<PaymentDTO, String>("regId"));
            clmStuId.setCellValueFactory(new PropertyValueFactory<PaymentDTO, String>("stuId"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getallPaymentDetail();
    }

}
