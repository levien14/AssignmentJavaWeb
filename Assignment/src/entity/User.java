package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String username;
    private String email;
    private String password;
    private String role;

    private String status;
    private HashMap<String, ArrayList<String>> errors;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public boolean isValid(){
        validate();
        return this.errors.size() == 0;
    }
    public void validate(){
        if (this.errors == null){
            this.errors = new HashMap<>();
        }
        ArrayList<String> userNameError = this.errors.get("username");
        ArrayList<String> emailError = this.errors.get("email");
        ArrayList<String> passwordError = this.errors.get("password");
        // validate username
        if (userNameError == null){
            userNameError = new ArrayList<>();
        }
        if (this.username == null || this.username.length() == 0 ){
            userNameError.add("Username is required");
        }
        if (this.username.length() < 2 || this.username.length() > 30){
            userNameError.add("Username must be betwwen 2 and 15 characters");
        }
        // validate email
        if (emailError == null){
            emailError = new ArrayList<>();
        }
        if (this.email == null || this.email.length() == 0){
            emailError.add("Email is required");
        }
        if (!(this.email.contains("@gmail.com"))){
            emailError.add("Email invalidate");
        }
        if (this.email.length() <11 || this.email.length()>50 ){
            emailError.add("Email must be betwwen 11 and 50 characters");
        }
        // validate password
        if (passwordError == null){
            passwordError = new ArrayList<>();
        }
        if (this.password == null || this.password.length() == 0){
            passwordError.add("Password is required");
        }
        if (this.password.length() <6 || this.password.length() >30){
            passwordError.add("Password must be betwwen 6 and 30 characters");
        }
        //
        if (userNameError.size() > 0){
            this.errors.put("username", userNameError);
        }
        if (emailError.size() > 0){
            this.errors.put("emailerror", emailError);
        }
        if (passwordError.size() > 0){
            this.errors.put("passwordError", passwordError);
        }
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }

    public void setErrors(HashMap<String, ArrayList<String>> errors) {
        this.errors = errors;
    }

}
