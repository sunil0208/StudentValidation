package StudentResult.Controller;

import StudentResult.Model.Result;
import StudentResult.Model.Student;
import StudentResult.Model.Subject;
import StudentResult.Model.User;
import StudentResult.Services.ResultService;
import StudentResult.Services.StudentService;
import StudentResult.Services.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sachin on 10/27/2014.
 */
public class SearchResultAdmin extends HttpServlet {
    Result result=new Result();
    Student student=new Student();
    ResultService resultService=new ResultService();
    SubjectService subjectService=new SubjectService();
    Subject subject=new Subject();
    StudentService studentService=new StudentService();
    User user=new User();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("USERNAME");
        if(username==null){
            request.getRequestDispatcher("/view/Login.jsp").forward(request,response);
        }
        else {
                int rollno=Integer.parseInt(request.getParameter("RollNo"));
                student.setRollno(rollno);

                String semester = request.getParameter("Semester");
                String examination = request.getParameter("Examination");


                result.setExamination(examination);
                student.setSemester(semester);
                resultService.getExamId(result);
                studentService.getSemId(student);

                if (studentService.Checkroll(student)) {
                    studentService.getStudentInfo(student);
                    request.setAttribute("student", true);
                    request.setAttribute("Student", student);
                    if (subjectService.CheckResult(student, result)) {
                        subjectService.getStudentMarks(subject, student, result);
                        subjectService.getSubjectList(subject, student, result);
                        resultService.getResult(result, subject);

                        request.setAttribute("marks", true);
                        request.setAttribute("Subject", subject);
                        request.setAttribute("Result", result);
                    } else {
                        request.setAttribute("marks", false);
                    }
                } else {
                    request.setAttribute("student", false);
                }

                request.getRequestDispatcher("/view/admin/SeeAdminResult.jsp").forward(request, response);
            }


        }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("USERNAME");
        if(username==null){
            request.getRequestDispatcher("/view/Login.jsp").forward(request,response);
        }
        else{

            request.getRequestDispatcher("/view/admin/SeeAdminResult.jsp").forward(request,response);
        }


    }
}
