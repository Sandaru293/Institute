package bo.custom.impl;

import bo.custom.ClassroomBO;
import dao.DAOFactory;
import dao.custom.ClassroomDAO;
import dto.ClassroomDTO;
import entity.Classroom;
import entity.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ClassroomBOImpl implements ClassroomBO {
    ClassroomDAO cl = (ClassroomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLASSROOM);

    @Override
    public boolean addClassroom(ClassroomDTO classroom) throws ClassNotFoundException, SQLException {
        Classroom cla = new Classroom(classroom.getClaId(),classroom.getTeaId());
        return cl.add(cla);
    }

    @Override
    public ClassroomDTO searchClassroom(String id) throws ClassNotFoundException, SQLException {
        Classroom cla = cl.search(id);
        return new ClassroomDTO(cla.getClaId(),cla.getTeaId());
    }

    @Override
    public ObservableList<ClassroomDTO> getAllClassroom() throws ClassNotFoundException, SQLException {
        ObservableList<Classroom> classrooms = cl.getAll();
        ObservableList<ClassroomDTO> list = FXCollections.observableArrayList();
        for(Classroom cl : classrooms){
            list.add(new ClassroomDTO(cl.getClaId(),cl.getTeaId()));
        }
        return list;
    }

    @Override
    public boolean deleteClassroom(String id) throws ClassNotFoundException, SQLException {
        return cl.delete(id);
    }

    @Override
    public boolean updateClassroom(ClassroomDTO classroom) throws ClassNotFoundException, SQLException {
        Classroom cla = new Classroom(classroom.getClaId(),classroom.getTeaId());
        return cl.update(cla);
    }


}
