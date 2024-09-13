package com.wipro.training.home_fin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Document(collection = "users")
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    
    private String password; // Encoded
    private String confirmPassword; // Plain text, used for validation only
    private String phoneNumber;
    private String employmentType;
    private int retirementAge;
    private String organizationType;
    private String employerName;
    private double maxLoanAmountGrantable;
    private double interestRate;
    private int tenure;
    private double loanAmount;
    private String dob;
    private String gender;
    private String nationality;
    private String aadharNo;
    private String panNo;
    private String propertyLocation;
    private String propertyName;
    private double estimatedAmount;
}
