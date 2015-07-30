package StudentResult.Controller;

import StudentResult.Model.Student;
import StudentResult.Model.User;
import StudentResult.Services.StudentService;
import StudentResult.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sachin on 10/27/2014.
 */
public class Signup extends HttpServlet {
    UserService userService=new UserService();
    User user=new User();
    Student student=new Student();
    StudentService studentService=new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("Name");
        int batch=Integer.parseInt(request.getParameter("Batch"));
        String username= request.getParameter("Username");
        String password=request.getParameter("Password");
        String roll=request.getParameter("RollNo");
        int rollno=Integer.parseInt(roll);

        student.setName(name);
        student.setBatch(batch);
        user.setUsername(username);
        user.setPassword(password);
        student.setRollno(rollno);

        List<User> fieldList=userService.getSignUpField(user);



        if(userService.CheckUsername(user)) {
            String result="UsernameFailed";
            request.setAttribute("Result",result);
        }

        else if(userService.CheckRoll(student)) {
            String result="RollFailed";
            request.setAttribute("Result",result);
        }

        else {
            studentService.insertStudentInfo(student);
            userService.insertUP(user,student);
            String result="Success";
            request.setAttribute("Result",result);
        }
        request.setAttribute("Field",fieldList);
        request.getRequestDispatcher("/view/admin/CreateAccount.jsp").forward(request,response);


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("USERNAME");
        if(username==null){
            request.getRequestDispatcher("/view/Login.jsp").forward(request,response);
        }
        else {

            List<User> fieldList = userService.getSignUpField(user);
            request.setAttribute("Field", fieldList);
            request.getRequestDispatcher("/view/admin/CreateAccount.jsp").forward(request, response);

        }

    }
}
