package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
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

public class CourseFormController implements Initializable {
    public TextField txtCouId;
    public TextField txtCouName;
    public TextField txtFee;

    @FXML
    private TableView<CourseDTO> tblCourse;

    @FXML
    private TableColumn<CourseDTO, String> clmCouId;

    @FXML
    private TableColumn<CourseDTO, String> clmCouName;

    @FXML
    private TableColumn<CourseDTO, String> clmFee;

    static CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);

    public void btnAddCourseOnAction(ActionEvent actionEvent) {
        CourseDTO course = new CourseDTO(txtCouId.getText(),txtCouName.getText(),Double.parseDouble(txtFee.getText()));
        try {
            boolean isAdded = courseBO.addCourse(course);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Add Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseDetail();
    }

    public void btnDeleteCourseOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = courseBO.deleteCourse(txtCouId.getText());
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Success",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Delete Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseDetail();
    }

    public void btnUpdateCourseOnAction(ActionEvent actionEvent) {
        CourseDTO course = new CourseDTO(txtCouId.getText(),txtCouName.getText(),Double.parseDouble(txtFee.getText()));
        try {
            boolean isUpdated = courseBO.updateCourse(course);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Success",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Update Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllCourseDetail();
    }

    public void btnSearchOnCourseAction(ActionEvent actionEvent) {
        try {
            CourseDTO course = courseBO.searchCourse(txtCouId.getText());
            if (course != null){
                txtCouId.setText(course.getCouId());
                txtCouName.setText(course.getCouName());
                txtFee.setText(Double.toString(course.getFee()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllCourseDetail(){
        try {
            ObservableList<CourseDTO> list = courseBO.getAllCourse();
            tblCourse.getItems().clear();
            tblCourse.setItems(list);

            clmCouId.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("couId"));
            clmCouName.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("couName"));
            clmFee.setCellValueFactory(new PropertyValueFactory<CourseDTO,String>("fee"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllCourseDetail();
    }
}
