package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.RegisterBO;
import bo.custom.StudentBO;
import db.DBConnection;
import dto.CourseDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {
    public ComboBox cmbCourse;
    public TextField txtRegId;
    public TextField txtFee;
    public TextField txtPayId;

    static RegisterBO registerBO = (RegisterBO) BOFactory.getInstance().getBO(BOFactory.BOType.REGISTER);
    public Label lblStuName;
    public Label lblCouName;
    public Label lblRegId;
    public Label lblDate;
    public Label lblPayId;
    public TextField txtStuId;
    public Label lblFee;
    CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOType.COURSE);
    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.STUDENT);

    public void cmbCourseOnAction(ActionEvent actionEvent) {
        try {
            CourseDTO course = courseBO.searchCourse(cmbCourse.getSelectionModel().getSelectedItem().toString());
            if (course != null){
                lblCouName.setText(course.getCouName());
                lblFee.setText(Double.toString(course.getFee()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCmbCourse(){
        try {
            ObservableList<CourseDTO>list = courseBO.getAllCourse();
            cmbCourse.getItems().clear();
            for (CourseDTO c : list){
                cmbCourse.getItems().add(c.getCouId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnRegisterConfirmOnAction(ActionEvent actionEvent) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement registerInsert = connection.prepareStatement("INSERT INTO Register VALUES(?,?,?)");
            registerInsert.setObject(1,lblRegId.getText());
            registerInsert.setObject(2,cmbCourse.getSelectionModel().getSelectedItem().toString());
            registerInsert.setObject(3,lblDate.getText());
            registerInsert.executeUpdate();

            PreparedStatement paymentInsert = connection.prepareStatement("INSERT INTO Payment VALUES(?,?,?,?)");
            paymentInsert.setObject(1,lblPayId.getText());
            paymentInsert.setObject(2,cmbCourse.getSelectionModel().getSelectedItem().toString());
            paymentInsert.setObject(3,lblRegId.getText());
            paymentInsert.setObject(4,txtStuId.getText());
            paymentInsert.executeUpdate();

            new Alert(Alert.AlertType.CONFIRMATION,"Register Confirm", ButtonType.OK).show();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void genarateRegisterId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT regId FROM Register ORDER BY regId DESC LIMIT 1");
            if (rst.next()){
                String regId = rst.getString(1);
                regId = regId.split("[A-Z]")[1];
                regId = "R00" + (Integer.parseInt(regId)+ 1);
                lblRegId.setText(regId);
            }else {
                lblRegId.setText("R001");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void genarateDate(){
        Date da = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(da);
        lblDate.setText(date);
    }

    private void genaratePaymentId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT payId FROM Payment ORDER BY payId DESC LIMIT 1");
            if (rst.next()){
                String payId = rst.getString(1);
                payId = payId.split("[A-Z]")[1];
                payId = "P00" + (Integer.parseInt(payId)+ 1);
                lblPayId.setText(payId);
            }else {
                lblPayId.setText("P001");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCmbCourse();
        genarateRegisterId();
        genarateDate();
        genaratePaymentId();
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
}
