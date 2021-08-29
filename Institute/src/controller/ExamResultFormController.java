package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.ExamBO;
import bo.custom.ExamResultBO;
import bo.custom.StudentBO;
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

public class ExamResultFormController implements Initializable {
    public TextField txtMark;
    public Label lblExaName;
    public Label lblStuName;
    public Label lblCouName;
    public TextField txtExaId;
    public TextField txtStuId;
    public TextField txtCouId;

    ExamResultBO examResultBO = (ExamResultBO) BOFactory.getInstance().getBO(BOFactory.BOType.EXAMRESULT);
    ExamBO examBO = (ExamBO) BOFactory.getInstance().getBO(BOFactory.BOType.EXAM);
    CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);
    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    @FXML
    private TableView<ExamResultDTO> tblExamResult;

    @FXML
    private TableColumn<ExamResultDTO, String> clmStuId;

    @FXML
    private TableColumn<ExamResultDTO, String> clmExaId;

    @FXML
    private TableColumn<ExamResultDTO, String> clmCouId;

    @FXML
    private TableColumn<ExamResultDTO, String> clmMark;

    public void btnAddExamResultOnAction(ActionEvent actionEvent) {
        ExamResultDTO examResult = new ExamResultDTO(txtStuId.getText(),txtExaId.getText(),txtCouId.getText(),txtMark.getText());
        try {
            boolean isAdded = examResultBO.addExamResult(examResult);
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
        getAllExamResultDetail();
    }

    public void btnUpdateExamResultOnAction(ActionEvent actionEvent) {
        ExamResultDTO examResult = new ExamResultDTO(txtStuId.getText(),txtExaId.getText(),txtCouId.getText(),txtMark.getText());
        try {
            boolean isUpdated = examResultBO.updateExamResult(examResult);
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
        getAllExamResultDetail();
    }

    public void btnSearchExamResultOnAction(ActionEvent actionEvent) {
        try {
            ExamResultDTO examResult = examResultBO.searchExamResult(txtStuId.getText());
            if(examResult!= null){
                txtStuId.setText(examResult.getStuId());
                txtExaId.setText(examResult.getExaId());
                txtCouId.setText(examResult.getCouId());
                txtMark.setText(examResult.getMark());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllExamResultDetail();
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

    public void getAllExamResultDetail(){
        try {
            ObservableList<ExamResultDTO> list = examResultBO.getAllExamResult();
            tblExamResult.getItems().clear();
            tblExamResult.setItems(list);

            clmStuId.setCellValueFactory(new PropertyValueFactory<ExamResultDTO,String>("stuId"));
            clmExaId.setCellValueFactory(new PropertyValueFactory<ExamResultDTO,String>("exaId"));
            clmCouId.setCellValueFactory(new PropertyValueFactory<ExamResultDTO,String>("couId"));
            clmMark.setCellValueFactory(new PropertyValueFactory<ExamResultDTO,String>("mark"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtExamOnAction(ActionEvent actionEvent) {
        try {
            ExamDTO exam = examBO.searchExam(txtExaId.getText());
            if (exam != null){
                lblExaName.setText(exam.getExaName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void txtCourseOnAction(ActionEvent actionEvent) {
        try {
            CourseDTO course = courseBO.searchCourse(txtCouId.getText());
            if (course != null){
                lblCouName.setText(course.getCouName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
