package controller;

import bo.BOFactory;
import bo.custom.ClassroomBO;
import bo.custom.TeacherBO;
import dto.ClassroomDTO;
import dto.TeacherDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable {
    public TextField txtClaId;
    public ComboBox cmbTeacher;
    public TextField txtTeaId;

    @FXML
    private TableView<ClassroomDTO> tblClassroom;

    @FXML
    private TableColumn<ClassroomDTO, String> clmClaId;

    @FXML
    private TableColumn<ClassroomDTO, String> clmTeaId;


    static ClassroomBO classroomBO = (ClassroomBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASSROOM);
    public Label lblTeaName;
    TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);

    public void btnAddClassroomOnAction(ActionEvent actionEvent) {
        ClassroomDTO classroom = new ClassroomDTO(txtClaId.getText(),cmbTeacher.getSelectionModel().getSelectedItem().toString());
        try {
            boolean isAdded = classroomBO.addClassroom(classroom);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success", ButtonType.OK).show();
                setCmbTeacher();
            }else {
                new Alert(Alert.AlertType.WARNING,"Add Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllClassroomDetail();
    }

    public void btnDeleteClassroomOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = classroomBO.deleteClassroom(txtClaId.getText());
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
        getAllClassroomDetail();
    }

    public void btnUpdateClassroomOnAction(ActionEvent actionEvent) {
        ClassroomDTO classroom = new ClassroomDTO(txtClaId.getText(),txtTeaId.getText());
        try {
            boolean isUpdated = classroomBO.updateClassroom(classroom);
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
        getAllClassroomDetail();
    }

    public void btnSearchClassroomOnAction(ActionEvent actionEvent) {
        try {
            ClassroomDTO classroom = classroomBO.searchClassroom(txtClaId.getText());
            if (classroom != null){
                txtClaId.setText(classroom.getClaId());
                txtTeaId.setText(classroom.getTeaId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void cmbTeacherOnAction(ActionEvent actionEvent) {
        try {
            TeacherDTO teacher = teacherBO.searchTeacher(cmbTeacher.getSelectionModel().getSelectedItem().toString());
            if (teacher != null){
                txtTeaId.setText(teacher.getTeaId());
                lblTeaName.setText(teacher.getTeaName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCmbTeacher(){
        try {
            ObservableList<TeacherDTO> list = teacherBO.getAllTeacher();
            cmbTeacher.getItems().clear();
            for (TeacherDTO t : list)
                cmbTeacher.getItems().add(t.getTeaId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllClassroomDetail(){
        try {
            ObservableList<ClassroomDTO>list = classroomBO.getAllClassroom();
            tblClassroom.getItems().clear();
            tblClassroom.setItems(list);

            clmClaId.setCellValueFactory(new PropertyValueFactory<ClassroomDTO,String>("claId"));
            clmTeaId.setCellValueFactory(new PropertyValueFactory<ClassroomDTO,String>("teaId"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCmbTeacher();
        getAllClassroomDetail();
    }
}
