package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManageExamController {
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

    public void btnExamDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ExamForm");
    }

    public void btnExamResultDetailOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ExamResultForm");
    }
}
