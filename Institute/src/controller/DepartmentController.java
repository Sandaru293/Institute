package controller;

import bo.BOFactory;
import bo.custom.DepartmentBO;
import dto.DepartmentDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DepartmentController implements Initializable {
    DepartmentBO departmentBO = (DepartmentBO) BOFactory.getInstance().getBO(BOFactory.BOType.DEPARTMENT);

    @FXML
    private TableView<DepartmentDTO> tblDepartment;

    @FXML
    private TableColumn<DepartmentDTO, String> clmDepId;

    @FXML
    private TableColumn<DepartmentDTO, String> clmDepName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getalldept();
    }
    public void getalldept(){
        try {
            ObservableList<DepartmentDTO> list = departmentBO.getAllDepartment();
            tblDepartment.getItems().clear();
            tblDepartment.setItems(list);

            clmDepId.setCellValueFactory(new PropertyValueFactory<DepartmentDTO, String>("depId"));
            clmDepName.setCellValueFactory(new PropertyValueFactory<DepartmentDTO, String>("depName"));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
