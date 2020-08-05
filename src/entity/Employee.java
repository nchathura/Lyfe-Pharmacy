package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String empId;
    private String empName;
    private String empAddress;
    private String email;
    private String contactNo;
    private LocalDate dateOfBirth;
    private LocalDate joinedDate;
    private BigDecimal salary;
    private String gender;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", joinedDate=" + joinedDate +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(String empId, String empName, String empAddress, String email, String contactNo, LocalDate dateOfBirth, LocalDate joinedDate, BigDecimal salary, String gender) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.email = email;
        this.contactNo = contactNo;
        this.dateOfBirth = dateOfBirth;
        this.joinedDate = joinedDate;
        this.salary = salary;
        this.gender = gender;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
