package bo.custom.impl;

import bo.custom.TeacherBO;
import dao.DAOFactory;
import dao.custom.TeacherDAO;
import dto.TeacherDTO;
import entity.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class TeacherBOImpl implements TeacherBO {
    TeacherDAO t = (TeacherDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TEACHER);

    @Override
    public boolean addTeacher(TeacherDTO teacher) throws ClassNotFoundException, SQLException {
        Teacher tea = new Teacher(teacher.getTeaId(),teacher.getTeaName(),teacher.getTeaTelNo(),teacher.getTeaEmail());
        return t.add(tea);
    }

    @Override
    public ObservableList<TeacherDTO> getAllTeacher() throws ClassNotFoundException, SQLException {
        ObservableList<Teacher> teachers = t.getAll();
        ObservableList<TeacherDTO> list = FXCollections.observableArrayList();
        for (Teacher t : teachers){
            list.add(new TeacherDTO(t.getTeaId(),t.getTeaName(),t.getTeaTelNo(),t.getTeaEmail()));
        }
        return list;
    }

    @Override
    public TeacherDTO searchTeacher(String id) throws ClassNotFoundException, SQLException {
        Teacher tea = t.search(id);
        return new TeacherDTO(tea.getTeaId(),tea.getTeaName(),tea.getTeaTelNo(),tea.getTeaEmail());
    }

    @Override
    public boolean deleteTeacher(String id) throws ClassNotFoundException, SQLException {
        return t.delete(id);
    }

    @Override
    public boolean updateTeacher(TeacherDTO teacher) throws ClassNotFoundException, SQLException {
        Teacher tea = new Teacher(teacher.getTeaId(),teacher.getTeaName(),teacher.getTeaEmail(),teacher.getTeaTelNo());
        return t.update(tea);
    }
}
