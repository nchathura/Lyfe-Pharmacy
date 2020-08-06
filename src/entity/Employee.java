package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Employee implements Serializable {
    private String empId;
    private String empName;
    private String empAddress;
    private String email;
    private String contactNo;
    private Date dateOfBirth;
    private Date joinedDate;
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

    public Employee(String empId, String empName, String empAddress, String email, String contactNo, Date dateOfBirth, Date joinedDate, BigDecimal salary, String gender) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
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
