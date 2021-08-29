package dao;

import bo.custom.impl.CourseClassroomBOImpl;
import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,TEACHER,COURSE,COURSECLASSROOM,CLASSROOM,CLASSROOMSTUDENT,REGISTER,EXAM,EXAMRESULT,DEPARTMENT,STUDENTDEPARTMENT,PAYMENT,QUEREY;
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case STUDENT:
                return new StudentDAOImpl();
            case TEACHER:
                return new TeacherDAOImpl();
            case COURSE:
                return new CourseDAOImpl();
            case CLASSROOM:
                return new ClassroomDAOImpl();
            case COURSECLASSROOM:
                return new CourseClassroomDAOImpl();
            case CLASSROOMSTUDENT:
                return new ClassroomStudenDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case EXAM:
                return new ExamDAOImpl();
            case EXAMRESULT:
                return new ExamResultDAOImpl();
            case STUDENTDEPARTMENT:
                return new StudentDepartmentDAOImpl();
            case DEPARTMENT:
                return new DepartmentDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            default:
                return null;
        }
    }
}
