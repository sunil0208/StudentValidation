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

/**
 * Created by sachin on 10/27/2014.
 */


public class Login extends HttpServlet {
    //begining of the program
    public void init(){

    }

    //create new user user and provide service
    User user=new User();
    UserService userService=new UserService();


    //create student and provide student service
    StudentService studentService=new StudentService();
    Student student=new Student();

    //action inside post method from servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //take parameters values from form of login and setting the objects instance variables
        String username= request.getParameter("Username");
        String password=request.getParameter("Password");
        System.out.println(username);
        System.out.println(password);
        System.out.println("-------------");
        user.setUsername(username);
        user.setPassword(password);
        String Username = username;

        //saving the username for session in USERNAME
        HttpSession session = request.getSession(true);
        session.setAttribute("USERNAME", Username);


        //forward to any user page  based on type of the user
         if(userService.loginAdmin(user)){

            String role="admin";
            session.setAttribute("Role",role);
             request.getRequestDispatcher("/view/admin/HomeAdmin.jsp").forward(request, response);
            }
         else if(userService.loginUser(user)) {
             String role="user";
             session.setAttribute("Role",role);
             request.getRequestDispatcher("/view/student/WelcomeStudent.jsp").forward(request,response);


        }
         else {
             String result="failed";
             request.setAttribute("Result",result);
             request.getRequestDispatcher("/view/login1.jsp").forward(request, response);
         }


    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Login.jsp").forward(request,response);


    }
}
