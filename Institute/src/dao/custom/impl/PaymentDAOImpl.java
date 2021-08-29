package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(Payment payment) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Payment payment) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Payment search(String id) throws ClassNotFoundException, SQLException {
        String SQL = "Select Course, count(stuId) From Course c, Register r, Payment p Where (c.couId = r.couId && r.regId = p.regId) group by c.couId";
        ResultSet rst = CrudUtil.executeQuery(SQL, id);
        if (rst.next()){
            return new Payment(rst.getString("payId"),rst.getString("couId"),rst.getString("regId"),rst.getString("stuId"));
        }
        return null;
    }

    @Override
    public ObservableList<Payment> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Payment";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Payment> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Payment(rst.getString("payId"),rst.getString("couId"),rst.getString("regId"),rst.getString("stuId")));
        }
        return list;
    }
}
