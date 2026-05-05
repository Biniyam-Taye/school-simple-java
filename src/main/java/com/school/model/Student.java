package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "First name is mandatory")
	private String firstName;

    @NotBlank(message = "Last name is mandatory")
	private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
	private String email;

    @NotBlank(message = "Grade level is mandatory")
	private String grade;

    @Min(value = 0, message = "GPA cannot be negative")
    @Max(value = 4, message = "GPA cannot exceed 4.0")
	private Double gpa;

    @Min(value = 0, message = "Attendance cannot be negative")
    @Max(value = 100, message = "Attendance cannot exceed 100")
	private Integer attendance;

    public Student() {}

    public Student(Long id, String firstName, String lastName, String email, String grade, Double gpa, Integer attendance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.gpa = gpa;
        this.attendance = attendance;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
    public Integer getAttendance() { return attendance; }
    public void setAttendance(Integer attendance) { this.attendance = attendance; }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
