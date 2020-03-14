package com.myproject.eshop.data.models.binding;

import com.myproject.eshop.web.anotations.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@FieldMatch.List(value = @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match!"))
public class UserRegisterBindingModel {

    private String id;
    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email(message = "Email is not valid!",
            regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,20}")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
