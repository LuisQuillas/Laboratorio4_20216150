package org.example.laboratorio4_20216150.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "bread")
    private Integer Bread;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "email", length = 25, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;


    @Column(name = "salary", precision = 8, scale = 2)
    private BigDecimal salary;

    @Column(name = "age", precision = 2, scale = 2)
    private BigDecimal Age;

    @Column(name = "city", precision = 2, scale = 2)
    private LocalDate City;

    @Column(name = "admission_date", precision = 2, scale = 2)
    private LocalDate admissionDate;



    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getBread() {
        return Bread;
    }

    public void setBread(Integer bread) {
        Bread = bread;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getAge() {
        return Age;
    }

    public void setAge(BigDecimal age) {
        Age = age;
    }

    public LocalDate getCity() {
        return City;
    }

    public void setCity(LocalDate city) {
        City = city;
    }


}