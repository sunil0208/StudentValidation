package StudentResult.Services;

import StudentResult.Model.Result;
import StudentResult.Model.Student;
import StudentResult.Model.Subject;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sachin on 11/18/2014.
 */
public class SubjectService {
    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    public String driver = "com.mysql.jdbc.Driver";




    public SubjectService() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRP", "root", "password");
            statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }



    public Subject getSubjectList(Subject subject, Student student, Result result){

        String query=("Select SubjectId,SubjectName,PassMarks,FullMarks from subjectlist where SemId='"+student.getSemesterId()+"'" +
                " and ExamId='"+result.getExamId()+"' ");
        try {


            resultSet=statement.executeQuery(query);
            resultSet.last();
            int totalSubject = resultSet.getRow();
            resultSet.beforeFirst();

            subject.setTotalSubject(totalSubject);
            int[] subjectID=new int[subject.getTotalSubject()];
            String[] subjectName=new String[subject.getTotalSubject()];
            int[] passMark=new int[subject.getTotalSubject()];
            int[] fullMark=new int[subject.getTotalSubject()];



            for(int i = 0;resultSet.next(); i++){
                subjectID[i] = resultSet.getInt("SubjectId");
                subjectName[i]=resultSet.getString("SubjectName");
                passMark[i]=resultSet.getInt("PassMarks");
                fullMark[i]=resultSet.getInt("FullMarks");

            }
            subject.setSubjectId(subjectID);
            subject.setSubjectName(subjectName);
            subject.setPassMarks(passMark);
            subject.setFullMarks(fullMark);
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;

    }
    public Subject getStudentMarks(Subject subject,Student student,Result result){
        try {
            System.out.println(student.getSemesterId());
            System.out.println(result.getExamId());
        if(student.getSemesterId()!=0&&result.getExamId()!=0){
            System.out.println("Its Semester and Examination wise");
            String query="select *from subjectmarks where SemId='"+student.getSemesterId()+"'" +
                    " and ExamId='"+result.getExamId()+"' and StudentId='"+student.getRollno()+"'";

            resultSet=statement.executeQuery(query);
        }
        else if(student.getSemesterId()==0 && result.getExamId()!=0){
            System.out.println("Its Examination wise");
            String query="select *from subjectmarks where  ExamId='"+result.getExamId()+"' and StudentId='"+student.getRollno()+"'";
            resultSet=statement.executeQuery(query);
        }
            else if(student.getSemesterId()!=0&&result.getExamId()==0){
            System.out.println("Its Examination wise");
                String query="select *from subjectmarks where SemId='"+student.getSemesterId()+"'and StudentId='"+student.getRollno()+"'";

            resultSet=statement.executeQuery(query);
        }
        else{
            System.out.println("Its All wise");
            String query="select *from subjectmarks where StudentId='"+student.getRollno()+"'";

            resultSet=statement.executeQuery(query);
        }

            resultSet.last();
            int totalSubject = resultSet.getRow();
            resultSet.beforeFirst();
            subject.setTotalSubject(totalSubject);

            subject.setTotalSubject(totalSubject);
            float[] marks=new float[totalSubject];
            int[] subjectId=new int[totalSubject];
            for(int i=0;resultSet.next();i++){
                subjectId[i]=resultSet.getInt("SubjectId");
                marks[i]=resultSet.getFloat("Marks");

            }
            subject.setSubjectId(subjectId);
            subject.setMarks(marks);
            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subject;

    }
   public boolean CheckResult(Student student,Result result){
       try {

           if(student.getSemesterId()!=0&&result.getExamId()!=0){
               String query="select *from subjectmarks where SemId='"+student.getSemesterId()+"'" +
                       " and ExamId='"+result.getExamId()+"' and StudentId='"+student.getRollno()+"'";

               resultSet=statement.executeQuery(query);
           }
           else if(student.getSemesterId()==0 && result.getExamId()!=0){
               String query="select *from subjectmarks where  ExamId='"+result.getExamId()+"' and StudentId='"+student.getRollno()+"'";
               resultSet=statement.executeQuery(query);
           }
           else if(student.getSemesterId()!=0&&result.getExamId()==0){
               String query="select *from subjectmarks where SemId='"+student.getSemesterId()+"'and StudentId='"+student.getRollno()+"'";

               resultSet=statement.executeQuery(query);
           }
           else{
               String query="select *from subjectmarks where StudentId='"+student.getRollno()+"'";

               resultSet=statement.executeQuery(query);
           }
           if(resultSet.next()){
               return true;
           }
           //connection.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return false;
   }



}
