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
}
