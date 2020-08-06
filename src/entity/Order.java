package entity;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
    private String orderId;
    private String empId;
    private Date orderDate;

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

    public Order(String orderId, String empId, Date orderDate) {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
