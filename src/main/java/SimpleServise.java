import dao.StudentDAO;
import model.Student;

import java.util.List;

public class SimpleServise {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.insertUser(new Student("Pavel", "PMail"));
//        studentDAO.insertUser(new Student("Alex", "AMail"));
//        Student student = studentDAO.selectUserById(1L);
//        System.out.println("USER: " + student.toString());
//        Student student1 = studentDAO.selectUserByName("Pavel");
//        System.out.println("Student1: " + student1.toString());
        List<Student> users = studentDAO.selectAllUsers();
        users.forEach(System.out::println);
    }
}