package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "First name is mandatory")
	private String firstName;

    @NotBlank(message = "Last name is mandatory")
	private String lastName;

    @NotBlank(message = "Subject is mandatory")
	private String subject;

    @NotBlank(message = "Department is mandatory")
	private String department;

    public Teacher() {}

    public Teacher(Long id, String firstName, String lastName, String subject, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
