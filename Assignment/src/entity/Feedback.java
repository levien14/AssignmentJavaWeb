package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private String email;
    private String description;
    private String status;
    HashMap<String, ArrayList<String>> errors;

    public Feedback() {
    }

    public Feedback(String email, String description) {
        this.email = email;
        this.description = description;
    }

    //Validate
    public boolean isValid(){
        validate();
        return this.errors.size() == 0;
    }

    public void validate(){
        if (this.errors == null){
            this.errors = new HashMap<>();
        }
        ArrayList<String> emailfeedbError = this.errors.get("email");
        ArrayList<String> desError = this.errors.get("description");
        if (emailfeedbError == null){
            emailfeedbError = new ArrayList<>();
        }
        if (this.email == null || this.email.length() == 0){
            emailfeedbError.add("Email is required");
        }
        if (!this.email.contains("@gmail.com")){
            emailfeedbError.add("Email invalidate");
        }
        if (desError == null){
            desError = new ArrayList<>();
        }
        if (this.description == null || this.description.length() == 0){
            desError.add("Description is required");
        }
        if (this.description.length() < 1 || this.description.length() > 255){
            desError.add("Description must be betwwen 11 and 50 characters");
        }
        if (emailfeedbError.size() > 0){
            this.errors.put("emailError",emailfeedbError);
        }
        if (desError.size() > 0){
            this.errors.put("desError",desError);
        }
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, ArrayList<String>> errors) {
        this.errors = errors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
