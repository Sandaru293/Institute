package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class StudentBOImpl implements StudentBO {
    StudentDAO s = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentDTO student) throws ClassNotFoundException, SQLException {
        Student stu = new Student(student.getStuId(),student.getStuName(),student.getBod(),student.getAddress(),student.getStuEmail(),student.getStuTelNo());
        return s.add(stu);
    }

    @Override
    public boolean deleteStudent(String id) throws ClassNotFoundException, SQLException {
        return s.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws ClassNotFoundException, SQLException {
        Student stu = s.search(id);
        return new StudentDTO(stu.getStuId(),stu.getStuName(),stu.getBod(),stu.getAddress(),stu.getStuEmail(),stu.getStuTelNo());
    }

    @Override
    public ObservableList<StudentDTO> getAllStudent() throws ClassNotFoundException, SQLException {
        ObservableList<Student> students = s.getAll();
        ObservableList<StudentDTO> list = FXCollections.observableArrayList();
        for (Student s : students){
            list.add(new StudentDTO(s.getStuId(),s.getStuName(),s.getBod(),s.getAddress(),s.getStuEmail(),s.getStuTelNo()));
        }
        return list;
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws ClassNotFoundException, SQLException {
        Student stu = new Student(student.getStuId(),student.getStuName(),student.getBod(),student.getAddress(),student.getStuEmail(),student.getStuTelNo());
        return s.update(stu);
    }

}
