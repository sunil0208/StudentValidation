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

/**
 * Created by sachin on 12/11/2014.
 */
public class SeeResultStudent extends HttpServlet {
    StudentService studentService=new StudentService();
    User user=new User();
    Student student=new Student();
    SubjectService subjectService=new SubjectService();
    ResultService resultService=new ResultService();
    Result result=new Result();
    Subject subject=new Subject();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("USERNAME");
        if(username==null){
            request.getRequestDispatcher("/view/Login.jsp").forward(request,response);
        }
        else {
            String semester = request.getParameter("Semester");
            String examination = request.getParameter("Examination");
            if(semester!=null&&examination!=null){
                user.setUsername(username);
                result.setExamination(examination);
                student.setSemester(semester);

                resultService.getExamId(result);
                studentService.getSemId(student);

                studentService.getRollNo(user, student);
                if (subjectService.CheckResult(student, result)) {
                    studentService.getStudentInfo(student);
                    request.setAttribute("Student", student);
                    subjectService.getStudentMarks(subject, student, result);
                    subjectService.getSubjectList(subject, student, result);
                    resultService.getResult(result, subject);
                    System.out.println(result.getTotal());
                    request.setAttribute("marks", true);
                    request.setAttribute("Subject", subject);
                    request.setAttribute("Result", result);
                } else {
                    request.setAttribute("marks", false);
                }
                System.out.println("Program is here");
                System.out.println(result.getTotal());
                System.out.println(subject.getMarks());
                request.getRequestDispatcher("/view/student/SeeStudentResult.jsp").forward(request,response);

            }
            else{
                request.getRequestDispatcher("/view/student/WelcomeStudent.jsp").forward(request,response);
            }


        }
    }
}
