package bo.custom.impl;

import bo.custom.RegisterBO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {
    @Override
    public StudentDTO searchStudent(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<StudentDTO> getAllStudent() throws ClassNotFoundException, SQLException, SQLException {
        return null;
    }
}
