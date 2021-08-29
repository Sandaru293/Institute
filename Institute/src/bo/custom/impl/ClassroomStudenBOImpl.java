package bo.custom.impl;

import bo.custom.ClassroomStudenBO;
import dao.DAOFactory;
import dao.custom.ClassroomStudenDAO;
import dto.ClassroomStudentDTO;
import entity.ClassroomStudent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ClassroomStudenBOImpl implements ClassroomStudenBO {
    ClassroomStudenDAO cls = (ClassroomStudenDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLASSROOMSTUDENT);

    @Override
    public boolean addClassroomStudent(ClassroomStudentDTO classroomStudent) throws ClassNotFoundException, SQLException {
        ClassroomStudent clstu = new ClassroomStudent(classroomStudent.getClaId(),classroomStudent.getStuId());
        return cls.add(clstu);
    }

    @Override
    public ObservableList<ClassroomStudentDTO> getAllClassroomStudent() throws ClassNotFoundException, SQLException {
        ObservableList<ClassroomStudent> classroomStudents = cls.getAll();
        ObservableList<ClassroomStudentDTO> list = FXCollections.observableArrayList();
        for(ClassroomStudent cls : classroomStudents){
            list.add(new ClassroomStudentDTO(cls.getClaId(),cls.getStuId()));
        }
        return list;
    }

    @Override
    public boolean deleteclassroomStuden(String id) throws ClassNotFoundException, SQLException {
        return cls.delete(id);
    }

    @Override
    public boolean updateClassroomStudent(ClassroomStudentDTO classroomStudent) throws ClassNotFoundException, SQLException {
        ClassroomStudent clstu = new ClassroomStudent(classroomStudent.getStuId(),classroomStudent.getClaId());
        return cls.update(clstu);
    }

    @Override
    public ClassroomStudentDTO searchClassroomStudent(String id) throws ClassNotFoundException, SQLException {
        ClassroomStudent clstu = cls.search(id);
        return new ClassroomStudentDTO(clstu.getStuId(),clstu.getClaId());
    }
}
