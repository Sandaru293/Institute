package controller;

import bo.BOFactory;
import bo.custom.ExamBO;
import dto.ExamDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ExamFormController implements Initializable {
    public TextField txtExaId;
    public TextField txtExaName;
    public TextField txtStartDate;

    @FXML
    private TableView<ExamDTO> tblExam;

    @FXML
    private TableColumn<ExamDTO, String> clmExaId;

    @FXML
    private TableColumn<ExamDTO, String> clmExaName;

    @FXML
    private TableColumn<ExamDTO, String> clmStartDate;

    static ExamBO examBO = (ExamBO) BOFactory.getInstance().getBO(BOFactory.BOType.EXAM);

    public void btnAddExamOnAction(ActionEvent actionEvent) {
        ExamDTO exam = new ExamDTO(txtExaId.getText(),txtExaName.getText(),txtStartDate.getText());
        try {
            boolean isAdded = examBO.addExam(exam);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Success", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Add Fail", ButtonType.OK).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAllExamDetail();
    }

    public void btnDeleteExamOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted = examBO.deleteExam(txtExaId.getText());
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
        getAllExamDetail();
    }

    public void btnUpdateExamOnAction(ActionEvent actionEvent) {
        ExamDTO exam = new ExamDTO(txtExaId.getText(),txtExaName.getText(),txtStartDate.getText());
        try {
            boolean isUpdated = examBO.updateExam(exam);
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
        getAllExamDetail();
    }

    public void btnSearchExamOnAction(ActionEvent actionEvent) {
        try {
            ExamDTO exam = examBO.searchExam(txtExaId.getText());
            if(exam != null){
                txtExaId.setText(exam.getExaId());
                txtExaName.setText(exam.getExaName());
                txtStartDate.setText(exam.getStart_date());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnGetAllExamOnAction(ActionEvent actionEvent) {

    }

    public void getAllExamDetail(){
        try {
            ObservableList<ExamDTO> list = examBO.getAllExam();
            tblExam.getItems().clear();
            tblExam.setItems(list);

            clmExaId.setCellValueFactory(new PropertyValueFactory<ExamDTO,String>("exaId"));
            clmExaName.setCellValueFactory(new PropertyValueFactory<ExamDTO,String>("exaName"));
            clmStartDate.setCellValueFactory(new PropertyValueFactory<ExamDTO,String>("start_date"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllExamDetail();
    }
}
