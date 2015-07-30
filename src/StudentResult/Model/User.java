package StudentResult.Model;

/**
 * Created by sachin on 11/3/2014.
 */
public class User {
    private  String username;
    private String password;
    private int totalField;

    public int getTotalField() {
        return totalField;
    }

    public void setTotalField(int totalField) {
        this.totalField = totalField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    private String field;

    public User() {
    }

    public User(String field) {
        this.field = field;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
