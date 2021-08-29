package controller;

import bo.BOFactory;
import bo.custom.DepartmentBO;
import bo.custom.StudentBO;
import bo.custom.StudentDepartmentBO;
import dto.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentDepartmentController implements Initializable {
    public TextField txtSalary;
    public Label lblDepName;
    public TextField txtStuId;
    public TextField txtDepId;
    public Label lblStuName;

    @FXML
    private TableView<StudentDepartmentDTO> tblStudentDepartment;

    @FXML
    private TableColumn<StudentDepartmentDTO, String> clmStuId;

    @FXML
    private TableColumn<StudentDepartmentDTO, String> clmDepId;

    @FXML
    private TableColumn<StudentDepartmentDTO, String> clmSalary;


    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);
    StudentDepartmentBO studentDepartmentBO = (StudentDepartmentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENTDEPARTMENT);
    DepartmentBO departmentBO = (DepartmentBO) BOFactory.getInstance().getBO(BOFactory.BOType.DEPARTMENT);

    public void btnSearchStudentDepartmentOnAction(ActionEvent actionEvent) {
        try {
            StudentDepartmentDTO studentDepartment = studentDepartmentBO.searchStudentDepartment(txtStuId.getText());
            if (studentDepartment != null){
                txtStuId.setText(studentDepartment.getStuId());
                txtDepId.setText(studentDepartment.getDepId());
                txtSalary.setText(Double.toString(studentDepartment.getSalary()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnUpdateStudentDepartmentOnAction(ActionEvent actionEvent) {
        StudentDepartmentDTO studentDepartment = new StudentDepartmentDTO(txtStuId.getText(),txtDepId.getText(),Double.parseDouble(txtSalary.getText()));
        try {
            boolean isUpdated = studentDepartmentBO.updateStudentDepartment(studentDepartment);
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
        getAllStudentDepartmentDetail();
    }

    public void btnAddStudentDepartmentOnAction(ActionEvent actionEvent) {
        StudentDepartmentDTO studentDepartment = new StudentDepartmentDTO(txtStuId.getText(),txtDepId.getText(),Double.parseDouble(txtSalary.getText()));
        try {
            boolean isAdded =studentDepartmentBO.addStudentDepartment(studentDepartment);
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
        getAllStudentDepartmentDetail();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllStudentDepartmentDetail();
    }

    public void txtDepartmentOnAction(ActionEvent actionEvent) {
        try {
            DepartmentDTO department = departmentBO.searchDepartment(txtDepId.getText());
            if (department != null){
                lblDepName.setText(department.getDepName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllStudentDepartmentDetail(){
        try {
            ObservableList<StudentDepartmentDTO>list = studentDepartmentBO.getAllStudentDepartment();
            tblStudentDepartment.getItems().clear();
            tblStudentDepartment.setItems(list);

            clmStuId.setCellValueFactory(new PropertyValueFactory<StudentDepartmentDTO,String>("stuId"));
            clmDepId.setCellValueFactory(new PropertyValueFactory<StudentDepartmentDTO,String>("depId"));
            clmSalary.setCellValueFactory(new PropertyValueFactory<StudentDepartmentDTO,String>("salary"));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
