package bo.custom.impl;

import bo.custom.StudentDepartmentBO;
import dao.DAOFactory;
import dao.custom.StudentDepartmentDAO;
import dto.StudentDepartmentDTO;
import entity.StudentDepartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class StudentDepartmentBOImpl implements StudentDepartmentBO {
    StudentDepartmentDAO sd = (StudentDepartmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENTDEPARTMENT);

    @Override
    public boolean addStudentDepartment(StudentDepartmentDTO studentDepartment) throws ClassNotFoundException, SQLException {
       StudentDepartment stde = new StudentDepartment(studentDepartment.getStuId(),studentDepartment.getDepId(),studentDepartment.getSalary());
       return sd.add(stde);
    }

    @Override
    public ObservableList<StudentDepartmentDTO> getAllStudentDepartment() throws ClassNotFoundException, SQLException {
        ObservableList<StudentDepartment> studentDepartments = sd.getAll();
        ObservableList<StudentDepartmentDTO> list = FXCollections.observableArrayList();
        for(StudentDepartment sd : studentDepartments){
            list.add(new StudentDepartmentDTO(sd.getStuId(),sd.getDepId(),sd.getSalary()));
        }
        return list;
    }

    @Override
    public StudentDepartmentDTO searchStudentDepartment(String id) throws ClassNotFoundException, SQLException {
        StudentDepartment stde = sd.search(id);
        return new StudentDepartmentDTO(stde.getStuId(),stde.getDepId(),stde.getSalary());
    }

    @Override
    public boolean updateStudentDepartment(StudentDepartmentDTO studentDepartment) throws ClassNotFoundException, SQLException {
        StudentDepartment stde = new StudentDepartment(studentDepartment.getStuId(),studentDepartment.getDepId(),studentDepartment.getSalary());
        return sd.update(stde);
    }
}
