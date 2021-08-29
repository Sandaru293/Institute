package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CourseBOImpl implements CourseBO {
    CourseDAO c = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean addCourse(CourseDTO course) throws ClassNotFoundException, SQLException {
        Course cou = new Course(course.getCouId(),course.getCouName(),course.getFee());
        return c.add(cou);
    }

    @Override
    public CourseDTO searchCourse(String id) throws ClassNotFoundException, SQLException {
        Course cou = c.search(id);
        return new CourseDTO(cou.getCouId(),cou.getCouName(),cou.getFee());
    }

    @Override
    public ObservableList<CourseDTO> getAllCourse() throws ClassNotFoundException, SQLException {
        ObservableList<Course> courses = c.getAll();
        ObservableList<CourseDTO> list = FXCollections.observableArrayList();
        for (Course c : courses){
            list.add(new CourseDTO(c.getCouId(),c.getCouName(),c.getFee()));
        }
        return list;
    }

    @Override
    public boolean deleteCourse(String id) throws ClassNotFoundException, SQLException {
        return c.delete(id);
    }

    @Override
    public boolean updateCourse(CourseDTO course) throws ClassNotFoundException, SQLException {
        Course cou = new Course(course.getCouId(),course.getCouName(),course.getFee());
        return c.update(cou);
    }
}
