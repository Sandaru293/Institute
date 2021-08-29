package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory= new BOFactory();
        }
        return boFactory;
    }
    public enum BOType{
        STUDENT,TEACHER,COURSE,COURSECLASSROOM,CLASSROOM,CLASSROOMSTUDENT,REGISTER,EXAM,EXAMRESULT,DEPARTMENT,STUDENTDEPARTMENT,PAYMENT,QUEREY;
    }

    public SuperBO getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return new StudentBOImpl();
            case TEACHER:
                return new TeacherBOImpl();
            case COURSE:
                return new CourseBOImpl();
            case CLASSROOM:
                return new ClassroomBOImpl();
            case COURSECLASSROOM:
                return new CourseClassroomBOImpl();
            case CLASSROOMSTUDENT:
                return new ClassroomStudenBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            case EXAM:
                return new ExamBOImpl();
            case EXAMRESULT:
                return new ExamResultBOImpl();
            case STUDENTDEPARTMENT:
                return new StudentDepartmentBOImpl();
            case DEPARTMENT:
                return new DepartmentBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            default:
                return null;
        }
    }
}
