package controller;

import bo.BOFactory;
import bo.custom.ClassroomBO;
import bo.custom.ClassroomStudenBO;
import bo.custom.StudentBO;
import dto.ClassroomDTO;
import dto.ClassroomStudentDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClassroomStudentController implements Initializable {
    public TextField txtClaId;
    public TextField txtStuId;
    public Label lblStuName;

    @FXML
    private TableView<ClassroomStudentDTO> tblClassroomStudent;

    @FXML
    private TableColumn<ClassroomStudentDTO, String> clmClaId;

    @FXML
    private TableColumn<ClassroomStudentDTO, String> clmStuId;

    static ClassroomStudenBO classroomStudenBO = (ClassroomStudenBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASSROOMSTUDENT);
    ClassroomBO classroomBO = (ClassroomBO) BOFactory.getInstance().getBO(BOFactory.BOType.CLASSROOM);
    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void btnAddClassroomStudentOnAction(ActionEvent actionEvent) {
        ClassroomStudentDTO classroomStudent = new ClassroomStudentDTO(txtClaId.getText(),txtStuId.getText());
        try {
            boolean isAdded = classroomStudenBO.addClassroomStudent(classroomStudent);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Add Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllClassroomStudent();
    }

    public void btnDeleteClassroomStudentOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = classroomStudenBO.deleteclassroomStuden(txtStuId.getText());
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
        getAllClassroomStudent();
    }

    public void btnUpdateClassroomStudentOnAction(ActionEvent actionEvent) {
        ClassroomStudentDTO classroomStudent = new ClassroomStudentDTO(txtStuId.getText(),txtClaId.getText());
        try {
            boolean isUpdated = classroomStudenBO.updateClassroomStudent(classroomStudent);
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
        getAllClassroomStudent();
    }

    public void btnSearchClassroomStudentOnAction(ActionEvent actionEvent) {
        try {
            ClassroomStudentDTO classroomStudent = classroomStudenBO.searchClassroomStudent(txtStuId.getText());
            if(classroomStudent!= null){
                txtStuId.setText(classroomStudent.getStuId());
                txtClaId.setText(classroomStudent.getClaId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllClassroomStudent();
    }

    public void txtStudentOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO student = studentBO.searchStudent(txtStuId.getText());
            if (student != null){
                lblStuName.setText(student.getStuName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllClassroomStudent(){
        try {
            ObservableList<ClassroomStudentDTO>list = classroomStudenBO.getAllClassroomStudent();
            tblClassroomStudent.getItems().clear();
            tblClassroomStudent.setItems(list);

            clmClaId.setCellValueFactory(new PropertyValueFactory<ClassroomStudentDTO,String>("claId"));
            clmStuId.setCellValueFactory(new PropertyValueFactory<ClassroomStudentDTO,String>("stuId"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtClassroomOnAction(ActionEvent actionEvent) {
        try {
            ClassroomDTO classroom = classroomBO.searchClassroom(txtClaId.getText());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
