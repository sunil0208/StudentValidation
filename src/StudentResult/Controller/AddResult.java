package StudentResult.Controller;

import StudentResult.Model.Result;
import StudentResult.Model.Student;
import StudentResult.Model.Subject;
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
 * Created by sachin on 10/27/2014.
 */
public class AddResult extends HttpServlet {
    Result result = new Result();
    Student student = new Student();
    ResultService resultService = new ResultService();
    SubjectService subjectService = new SubjectService();
    Subject subject = new Subject();
    StudentService studentService = new StudentService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String semester = (String) session.getAttribute("Semester");
        String examination = (String) session.getAttribute("Examination");

        result.setExamination(examination);
        student.setSemester(semester);

        resultService.getExamId(result);
        studentService.getSemId(student);


        subjectService.getSubjectList(subject, student, result);


        int rollno = Integer.parseInt(request.getParameter("RollNo"));

        float[] Marks = new float[subject.getTotalSubject()];
        String[] subjectName = new String[subject.getTotalSubject()];

        for (int i = 0; i < subject.getTotalSubject(); i++) {
            subjectName[i] = subject.getSubjectName()[i];
        }

        for (int i = 0; i < subject.getTotalSubject(); i++) {
            Marks[i] = Float.parseFloat(request.getParameter(subjectName[i]));

        }
        student.setRollno(rollno);
        subject.setMarks(Marks);

        try {
            resultService.insert(subject, student, result);
            request.setAttribute("result", true);
            request.setAttribute("Subject", subject);
        } catch (Exception e) {
            request.setAttribute("result", false);
            request.setAttribute("Subject", subject);

        }
        request.getRequestDispatcher("/view/admin/PublishResult.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("USERNAME");
        if (username == null) {
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
        } else {

            String semester = request.getParameter("Semester");
            String examination = request.getParameter("Examination");
            System.out.println(semester);
            System.out.println(examination);
            if(semester!=null&&examination!=null){
                result.setExamination(examination);
                student.setSemester(semester);

                resultService.getExamId(result);
                studentService.getSemId(student);


                session.setAttribute("Semester", semester);
                session.setAttribute("Examination", examination);

                subjectService.getSubjectList(subject, student, result);


                request.setAttribute("Subject", subject);
                request.getRequestDispatcher("/view/admin//PublishResult.jsp").forward(request, response);

            }
            else{
                request.getRequestDispatcher("/view/admin/HomeAdmin.jsp").forward(request,response);
            }



        }
    }
}

