package StudentResult.Services;

import StudentResult.Model.Student;
import StudentResult.Model.User;

import java.sql.*;

/**
 * Created by sachin on 10/27/2014.
 */
public class StudentService {
    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    public String driver = "com.mysql.jdbc.Driver";

    public StudentService() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRP", "root", "password");//SRP Database name
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertStudentInfo(Student student) {
        try {

            statement.execute("insert into studentinfo  values('" + student.getRollno() + "','" + student.getName() + "'," +
                    "'" + student.getBatch() + "')");//Inserting values to table
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean Checkroll(Student student) {
        try {
            String query = "(select RollNo from studentinfo where RollNo  = '" + student.getRollno() + "')";
            resultSet = statement.executeQuery(query);

            if (resultSet.next())
                return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }


    public Student getSemId(Student student) {
        String query = "select SemId from semesterinfo where Semester='" + student.getSemester() + "'";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int semId = resultSet.getInt("SemId");
                student.setSemesterId(semId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public Student getStudentInfo(Student student) {
        String query = "select *from studentinfo where RollNo='" + student.getRollno() + "'";
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                student.setName(resultSet.getString("Name"));
                student.setBatch(resultSet.getInt("Batch"));
                student.setRollno(resultSet.getInt("RollNo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public void getRollNo(User user, Student student) {
        try {
            System.out.println(user.getUsername());
            String query = "(select RollNo from ups where Username='" + user.getUsername() + "')";
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                student.setRollno(resultSet.getInt("RollNo"));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}


