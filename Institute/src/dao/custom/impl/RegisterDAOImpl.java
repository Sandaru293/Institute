package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RegisterDAO;
import entity.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean add(Register register) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Register register) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Register search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Register> getAll() throws ClassNotFoundException, SQLException {
        String SQL = "Select * From Register";
        ResultSet rst = CrudUtil.executeQuery(SQL);
        ObservableList<Register> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Register(rst.getString("regId"),rst.getString("couId"),rst.getString("date")));
        }
        return list;
    }
}
