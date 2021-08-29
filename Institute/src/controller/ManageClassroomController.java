package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageClassroomController {
    public AnchorPane root;

    public void initialize() throws IOException {
        //defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));
    }

//        public  void defalt() throws IOException {
//        setUi("Classroom");
//    }

    public void btnTeacherClassroomDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("Classroom");
    }

    public void btnCourseClassroomDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("CourseClassroom");
    }

    public void btnStudentClassroomDetailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ClassroomStudent");
    }
}
