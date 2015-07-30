package StudentResult.Services;

import StudentResult.Model.Result;
import StudentResult.Model.Student;
import StudentResult.Model.Subject;

import java.sql.*;


/**
 * Created by sachin on 10/27/2014.
 */
public class ResultService {



    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    public String driver = "com.mysql.jdbc.Driver";



    public ResultService() {
        try {

            Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRP", "root", "password");
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }


    public Result getExamId(Result result){
        String query="select ExamId from examinfo where Exam='"+result.getExamination()+"'";
        try {
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                int examId=resultSet.getInt("ExamId");
                result.setExamId(examId);
            }
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }





    public void insert(Subject subject,Student student,Result result) throws SQLException {

            for(int i=0;i<(subject.getTotalSubject());i++) {
                statement.execute("insert into subjectmarks values ('" + student.getRollno() + "'," +
                        "'" + subject.getSubjectId()[i] + "','" + student.getSemesterId() + "'," +
                        "'" + result.getExamId() + "','" + subject.getMarks()[i] + "')");
            }
        //connection.close();
    }



    public Result getResult(Result result,Subject subject){
        int fullMarks=0;
        float total=0;
        for(int i=0;i<subject.getTotalSubject();i++){
           fullMarks+=subject.getFullMarks()[i];
        }
        for(int i=0;i<subject.getTotalSubject();i++){
            total+=subject.getMarks()[i];
        }
        result.setTotal(total);
        result.setPercentage((total*100)/fullMarks);
        for(int i=0;i<subject.getTotalSubject();i++){
            if(subject.getMarks()[i]<subject.getPassMarks()[i]){
                result.setStatus("Fail");
                break;
            }
            else
                result.setStatus("Pass");

        }
        return result;

    }

}
