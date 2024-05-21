package org.essaadani.dto;

public class UpdateUserDTO {
    private String fullName;
    private String age;
    private String email;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String fullName, String age, String email) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
