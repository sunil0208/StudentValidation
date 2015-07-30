package StudentResult.Services;


import StudentResult.Model.Student;
import StudentResult.Model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sachin on 10/27/2014.
 */
public class UserService {

    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    public String driver = "com.mysql.jdbc.Driver";


//connect to the database when object of userservice is made
    public UserService() {
        try {

            Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRP", "root", "password");
            statement = connection.createStatement();
        } catch (Exception ex) {System.out.println("Error" + ex);

        }
    }

    //takes user object and return true or false for login
    public boolean loginAdmin(User user) {
        try {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());

            //query to select username and password to check
            /*Class.forName(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SRP", "root", "password");
            statement = connection.createStatement();*/
            String query = "select * from admin where Username = '" + user.getUsername() + "' and" +
                    " Password = '" + user.getPassword() + "'";
            resultSet = statement.executeQuery(query);

            //if available value of field
            if (resultSet.next())
                return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }
//take user login for user
    public boolean loginUser(User user) {
        try {
            String query = "select * from ups where Username = '" + user.getUsername() + "' and" +
                    " Password = '" + user.getPassword() + "'";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }




    public boolean CheckUsername(User user) {
        try {
            String query = "(select Username from ups where Username = '"+user.getUsername()+"')";
            resultSet = statement.executeQuery(query);

            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }



    //to check roll number of student
    public boolean CheckRoll(Student student) {
        try {
            String query = "(select RollNo from ups where RollNo  = '"+student.getRollno()+"')";
            resultSet = statement.executeQuery(query);

            if(resultSet.next())
                return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }


    //to insert the values of user and student
    public void insertUP(User user,Student student){
        try {

            statement.execute("insert into ups  values('"+user.getUsername()+"','"+user.getPassword()+"','"+student.getRollno()+"')");//table_name
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //return list of User type that have username, password, field
    public List<User> getSignUpField(User user){
        List<User> fieldList=new LinkedList<User>();

        String query="select *from accountfield order by Id ";
        try {
            resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                user=new User(resultSet.getString("Fields"));
                fieldList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fieldList;
    }


}




