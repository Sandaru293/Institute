package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;

    public void initialize() throws IOException {
        //defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));
    }


//    public  void defalt() throws IOException {
//        setUi("StudentForm");
//    }

    public void btnTeacherDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("TeacherForm");
    }

    public void btnStudentDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("StudentForm");
    }

    public void btnCourseDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CourseForm");
    }

    public void btnRegisterNowOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("RegisterForm");
    }

    public void btnManageClassroomOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ManageClassroom");
    }

    public void btnDepartmentDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ManageDepartment");
    }

    public void btnManageExamOnAction(MouseEvent mouseEvent) {
    }

    public void btnManageExamDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ManageExam");
    }

    public void btnPaymentDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PaymentForm");
    }
}
