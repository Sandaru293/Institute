package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageDepartmentController {
    public AnchorPane root;

    public void initialize() throws IOException {
        //defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));
    }

    public void btnDepartmentDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Department");
    }

    public void btnStudentDepartmentDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StudentDepartment");
    }
}
