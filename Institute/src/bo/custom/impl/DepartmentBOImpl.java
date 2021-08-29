package bo.custom.impl;

import bo.custom.DepartmentBO;
import dao.DAOFactory;
import dao.custom.DepartmentDAO;
import dto.DepartmentDTO;
import entity.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class DepartmentBOImpl implements DepartmentBO {
    DepartmentDAO d= (DepartmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DEPARTMENT);

    @Override
    public DepartmentDTO searchDepartment(String id) throws ClassNotFoundException, SQLException {
        Department dep = d.search(id);
        return new DepartmentDTO(dep.getDepId(),dep.getDepName());
    }

    @Override
    public ObservableList<DepartmentDTO> getAllDepartment() throws ClassNotFoundException, SQLException {
        ObservableList<Department> departments = d.getAll();
        ObservableList<DepartmentDTO> list = FXCollections.observableArrayList();
        for (Department d : departments){
            list.add(new DepartmentDTO(d.getDepId(),d.getDepName()));
        }
        return list;
    }
}
