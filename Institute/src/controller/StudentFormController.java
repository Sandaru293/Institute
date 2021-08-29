package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
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
import java.util.regex.Pattern;

public class StudentFormController implements Initializable {
    public TextField txtStuId;
    public TextField txtStuName;
    public TextField txtBod;
    public TextField txtAddress;
    public TextField txtStuEmail;
    public TextField txtStuTelNo;

    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TableColumn<StudentDTO, String> clmStuId;

    @FXML
    private TableColumn<StudentDTO, String> clmStuName;

    @FXML
    private TableColumn<StudentDTO, String> clmBod;

    @FXML
    private TableColumn<StudentDTO, String> clmAddress;

    @FXML
    private TableColumn<StudentDTO, String> clmStuEmail;

    @FXML
    private TableColumn<StudentDTO, String> clmStuTelNo;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void btnAddOnAction(ActionEvent actionEvent) {
    StudentDTO student = new StudentDTO(txtStuId.getText(),txtStuName.getText(),txtBod.getText(),txtAddress.getText(),txtStuEmail.getText(),txtStuTelNo.getText());
        try {
        boolean isAdded = studentBO.addStudent(student);
                    if (isAdded) {
                        new Alert(Alert.AlertType.CONFIRMATION, "Add Success", ButtonType.OK).show();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Add Fail", ButtonType.OK).show();
                    }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllStudentDetail();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = studentBO.deleteStudent(txtStuId.getText());
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
        getAllStudentDetail();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        StudentDTO student = new StudentDTO(txtStuId.getText(),txtStuName.getText(),txtBod.getText(),txtAddress.getText(),txtStuEmail.getText(),txtStuTelNo.getText());
        try {
            boolean isUpdate = studentBO.updateStudent(student);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Success",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Update Fail",ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllStudentDetail();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO student = studentBO.searchStudent(txtStuId.getText());
            if (student != null){
                txtStuId.setText(student.getStuId());
                txtStuName.setText(student.getStuName());
                txtBod.setText(student.getBod());
                txtAddress.setText(student.getAddress());
                txtStuEmail.setText(student.getStuEmail());
                txtStuTelNo.setText(student.getStuTelNo());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllStudentDetail(){
        try {
            ObservableList<StudentDTO> list = studentBO.getAllStudent();
            tblStudent.getItems().clear();
            tblStudent.setItems(list);

            clmStuId.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("stuId"));
            clmStuName.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("stuName"));
            clmBod.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("bod"));
            clmAddress.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("address"));
            clmStuEmail.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("stuEmail"));
            clmStuTelNo.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("stuTelNo"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllStudentDetail();
    }

}














//    String stuId = txtStuId.getText();
//    String stuTelNo = txtStuTelNo.getText();
//    String stuEmail = txtStuEmail.getText();
//
//    StudentDTO student = new StudentDTO(txtStuId.getText(),txtStuName.getText(),txtBod.getText(),txtAddress.getText(),txtStuEmail.getText(),txtStuTelNo.getText());
//        try {
//        boolean isAdded = studentBO.addStudent(student);
//        if (Pattern.compile("^(S00)[0-9]{1,}$").matcher(stuId).matches()){
//            if (Pattern.compile("^[0-9]{1,}.[0-9]{2}$").matcher(stuTelNo).matches()) {
//                if (Pattern.compile("^[a-z]{10,}@(gmail).(com)$").matcher(stuEmail).matches()) {
//                    if (isAdded) {
//                        new Alert(Alert.AlertType.CONFIRMATION, "Add Success", ButtonType.OK).show();
//                    } else {
//                        new Alert(Alert.AlertType.WARNING, "Add Fail", ButtonType.OK).show();
//                    }
//                }else{
//                    txtStuEmail.setStyle("-fx-text-inner-color: #BA5503");
//                    new Alert(Alert.AlertType.WARNING,"Email Pattern Not Matched", ButtonType.OK).show();
//                    txtStuEmail.requestFocus();
//                }
//            }else{
//                txtStuTelNo.setStyle("-fx-text-inner-color: #BA5503");
//                new Alert(Alert.AlertType.WARNING,"Tel.No Pattern Not Matched", ButtonType.OK).show();
//                txtStuTelNo.requestFocus();
//            }
//        }else{
//            txtStuId.setStyle("-fx-text-inner-color: #BA5503");
//            new Alert(Alert.AlertType.WARNING,"Student ID Pattern Not Matched", ButtonType.OK).show();
//            txtStuId.requestFocus();
//        }