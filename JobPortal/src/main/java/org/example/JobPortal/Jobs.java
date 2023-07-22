package org.example.JobPortal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")

public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private String description;
    private String location;
    @Min(value = 20000, message = "salary should be above 20000")
    private Double salary;
    @Email
    private String companyEmail;
    private String companyName;
    private String employerName;
    @Enumerated(EnumType.STRING)
    private Type jobType;

    private LocalDate appliedDate;
}
