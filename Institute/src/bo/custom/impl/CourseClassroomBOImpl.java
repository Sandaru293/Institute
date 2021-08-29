package bo.custom.impl;

import bo.custom.CourseClassroomBO;
import dao.DAOFactory;
import dao.custom.CourseClassroomDAO;
import dto.CourseClassroomDTO;
import entity.CourseClassroom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CourseClassroomBOImpl implements CourseClassroomBO {
    CourseClassroomDAO cc = (CourseClassroomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSECLASSROOM);

    @Override
    public boolean addCourseClassroom(CourseClassroomDTO courseClassroom) throws ClassNotFoundException, SQLException {
        CourseClassroom cocl = new CourseClassroom(courseClassroom.getCouId(),courseClassroom.getClaId());
        return cc.add(cocl);
    }

    @Override
    public ObservableList<CourseClassroomDTO> getAllCourseClassroom() throws ClassNotFoundException, SQLException {
        ObservableList<CourseClassroom> courseClassrooms = cc.getAll();
        ObservableList<CourseClassroomDTO> list = FXCollections.observableArrayList();
        for(CourseClassroom cc : courseClassrooms){
            list.add(new CourseClassroomDTO(cc.getCouId(),cc.getClaId()));
        }
        return list;
    }

    @Override
    public CourseClassroomDTO searchCourseClassroom(String id) throws ClassNotFoundException, SQLException {
        CourseClassroom cocl = cc.search(id);
        return new CourseClassroomDTO(cocl.getCouId(),cocl.getClaId());
    }

    @Override
    public boolean deletecourseClassroom(String id) throws ClassNotFoundException, SQLException {
        return cc.delete(id);
    }

    @Override
    public boolean updatecourseClassroom(CourseClassroomDTO courseClassroom) throws ClassNotFoundException, SQLException {
        CourseClassroom cocl = new CourseClassroom(courseClassroom.getCouId(),courseClassroom.getClaId());
        return cc.update(cocl);
    }


}
