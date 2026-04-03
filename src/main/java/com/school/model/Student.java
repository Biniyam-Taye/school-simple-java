package com.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
