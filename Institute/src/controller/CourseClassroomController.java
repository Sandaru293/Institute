package controller;

import bo.BOFactory;
import bo.custom.ClassroomBO;
import bo.custom.CourseBO;
import bo.custom.CourseClassroomBO;
import dto.ClassroomDTO;
import dto.CourseClassroomDTO;
import dto.CourseDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CourseClassroomController implements Initializable {
    public ComboBox cmbCourse;
    public ComboBox cmbClassroom;
    public Label lblCouName;
    public TextField txtCouId;
    public TextField txtClaId;

    @FXML
    private TableView<CourseClassroomDTO> tblCourseClassroom;

    @FXML
    private TableColumn<CourseClassroomDTO, String> clmCouId;

    @FXML
    private TableColumn<CourseClassroomDTO, String> clmClaId;

    ClassroomBO classroomBO = (ClassroomBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASSROOM);
    CourseClassroomBO courseClassroomBO = (CourseClassroomBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSECLASSROOM);
    CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);

    public void btnAddCourseClassroomOnAction(ActionEvent actionEvent) {
        CourseClassroomDTO courseClassroom = new CourseClassroomDTO(cmbCourse.getSelectionModel().getSelectedItem().toString(),cmbClassroom.getSelectionModel().getSelectedItem().toString());
        try {
            boolean isAdded = courseClassroomBO.addCourseClassroom(courseClassroom);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success", ButtonType.OK).show();
                setCmbCourse();
                setCmbClassroom();
            }else {
                new Alert(Alert.AlertType.WARNING,"Add Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseClassroomDetail();
    }

    public void btnDeleteCourseClassroomOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = courseClassroomBO.deletecourseClassroom(txtCouId.getText());
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Success",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Delete Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseClassroomDetail();
    }

    public void btnUpdateCourseClassroomOnAction(ActionEvent actionEvent) {
        CourseClassroomDTO courseClassroom = new CourseClassroomDTO(txtCouId.getText(),txtClaId.getText());
        try {
            boolean isUpdated = courseClassroomBO.updatecourseClassroom(courseClassroom);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Success",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Update Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseClassroomDetail();
    }

    public void btnSearchCourseClassroomOnAction(ActionEvent actionEvent) {
        try {
            CourseClassroomDTO courseClassroom = courseClassroomBO.searchCourseClassroom(txtCouId.getText());
            if (courseClassroom != null){
                txtCouId.setText(courseClassroom.getCouId());
                txtClaId.setText(courseClassroom.getClaId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cmbCourseOnAction(ActionEvent actionEvent) {
        try {
            CourseDTO course = courseBO.searchCourse(cmbCourse.getSelectionModel().getSelectedItem().toString());
            if (course != null){
                txtCouId.setText(course.getCouId());
                lblCouName.setText(course.getCouName());

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCmbCourse(){
        try {
            ObservableList<CourseDTO> list = courseBO.getAllCourse();
            cmbCourse.getItems().clear();
            for (CourseDTO c : list) {
                cmbCourse.getItems().add(c.getCouId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cmbClassroomOnAction(ActionEvent actionEvent) {
        try {
            ClassroomDTO classroom = classroomBO.searchClassroom(cmbClassroom.getSelectionModel().getSelectedItem().toString());
            if (classroom != null){
                txtClaId.setText(classroom.getClaId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCmbClassroom() {
        try {
            ObservableList<ClassroomDTO> list = classroomBO.getAllClassroom();
            cmbClassroom.getItems().clear();
            for (ClassroomDTO cl : list) {
                cmbClassroom.getItems().add(cl.getClaId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllCourseClassroomDetail(){
        try {
            ObservableList<CourseClassroomDTO>list = courseClassroomBO.getAllCourseClassroom();
            tblCourseClassroom.getItems().clear();
            tblCourseClassroom.setItems(list);

            clmCouId.setCellValueFactory(new PropertyValueFactory<CourseClassroomDTO,String>("couId"));
            clmClaId.setCellValueFactory(new PropertyValueFactory<CourseClassroomDTO,String>("claId"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCmbCourse();
        setCmbClassroom();
        getAllCourseClassroomDetail();
    }
}
