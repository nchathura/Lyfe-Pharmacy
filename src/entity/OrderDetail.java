package entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {
    private OrderDetailPK orderDetailPK;
    private BigDecimal qty;
    private BigDecimal unitPrice;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public OrderDetail() {
    }


    public OrderDetail(OrderDetailPK orderDetailPK, BigDecimal qty, BigDecimal unitPrice) {
        this.orderDetailPK = orderDetailPK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    public OrderDetail(String orderId,String itemCode, BigDecimal qty, BigDecimal unitPrice) {
        this.orderDetailPK = new OrderDetailPK(orderId,itemCode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }
}
