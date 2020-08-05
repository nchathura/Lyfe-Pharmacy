package entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Serializable {
    private String orderId;
    private String empId;
    private LocalDate orderDate;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", empId='" + empId + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public Order() {
    }

    public Order(String orderId, String empId, LocalDate orderDate) {
        this.orderId = orderId;
        this.empId = empId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
