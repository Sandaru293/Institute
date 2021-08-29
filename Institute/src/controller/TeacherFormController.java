package controller;

import bo.BOFactory;
import bo.custom.TeacherBO;
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

public class TeacherFormController implements Initializable {
    public TextField txtTeaId;
    public TextField txtTeaName;
    public TextField txtTeaEmail;
    public TextField txtTeaTelNo;

    @FXML
    private TableView<TeacherDTO> tblTeacher;

    @FXML
    private TableColumn<TeacherDTO, String> clmTeaId;

    @FXML
    private TableColumn<TeacherDTO, String> clmTeaName;

    @FXML
    private TableColumn<TeacherDTO, String> clmTeaEmail;

    @FXML
    private TableColumn<TeacherDTO, String> clmTeaTelNo;


    static TeacherBO teacherBO = (TeacherBO) BOFactory.getInstance().getBO(BOFactory.BOType.TEACHER);

    public void btnAddTeacherOnAction(ActionEvent actionEvent) {
        TeacherDTO teacher = new TeacherDTO(txtTeaId.getText(),txtTeaName.getText(),txtTeaEmail.getText(),txtTeaTelNo.getText());
        try {
            boolean isAdded = teacherBO.addTeacher(teacher);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Add Fail", ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllTeacherDetail();
    }

    public void btnDeleteTeacherOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = teacherBO.deleteTeacher(txtTeaId.getText());
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
        getAllTeacherDetail();
    }

    public void btnUpdateTeacherOnAction(ActionEvent actionEvent) {
        TeacherDTO teacher = new TeacherDTO(txtTeaId.getText(),txtTeaName.getText(),txtTeaEmail.getText(),txtTeaTelNo.getText());
        try {
            boolean isUpdated = teacherBO.updateTeacher(teacher);
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
        getAllTeacherDetail();
    }

    public void btnSearchTeacherOnAction(ActionEvent actionEvent) {
        try {
            TeacherDTO teacher = teacherBO.searchTeacher(txtTeaId.getText());
            if (teacher != null){
                txtTeaId.setText(teacher.getTeaId());
                txtTeaName.setText(teacher.getTeaName());
                txtTeaEmail.setText(teacher.getTeaEmail());
                txtTeaTelNo.setText(teacher.getTeaTelNo());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllTeacherDetail(){
        try {
            ObservableList<TeacherDTO> list = teacherBO.getAllTeacher();
            tblTeacher.getItems().clear();
            tblTeacher.setItems(list);

            clmTeaId.setCellValueFactory(new PropertyValueFactory<TeacherDTO,String>("teaId"));
            clmTeaName.setCellValueFactory(new PropertyValueFactory<TeacherDTO,String>("teaName"));
            clmTeaTelNo.setCellValueFactory(new PropertyValueFactory<TeacherDTO,String>("teaTelNo"));
            clmTeaEmail.setCellValueFactory(new PropertyValueFactory<TeacherDTO,String>("teaEmail"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllTeacherDetail();
    }
}
