package bo.custom;

import bo.SuperBO;
import dto.PaymentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface PaymentBO extends SuperBO {
    ObservableList<PaymentDTO> getAllPayment()throws ClassNotFoundException, SQLException;
}
