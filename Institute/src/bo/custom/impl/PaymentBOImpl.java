package bo.custom.impl;

import bo.custom.PaymentBO;
import dao.DAOFactory;
import dao.custom.PaymentDAO;
import dto.PaymentDTO;
import entity.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO p = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public ObservableList<PaymentDTO> getAllPayment() throws ClassNotFoundException, SQLException {
        ObservableList<Payment> payments = p.getAll();
        ObservableList<PaymentDTO> list = FXCollections.observableArrayList();
        for (Payment p : payments){
            list.add(new PaymentDTO(p.getPayId(),p.getCouId(),p.getRegId(),p.getStuId()));
        }
        return list;
    }
}
