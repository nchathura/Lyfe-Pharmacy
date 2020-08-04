package util;

import com.jfoenix.controls.JFXButton;

import java.math.BigDecimal;

public class PlaceOrderTM {
    private String itemCode;
    private String itemDescription;
    private BigDecimal unitPrice;
    private BigDecimal qty;
    private BigDecimal total;
    private JFXButton jfxButton;

    @Override
    public String toString() {
        return "PlaceOrderTM{" +
                "itemCode='" + itemCode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                ", total=" + total +
                ", jfxButton=" + jfxButton +
                '}';
    }

    public PlaceOrderTM() {
    }

    public PlaceOrderTM(String itemCode, String itemDescription, BigDecimal unitPrice, BigDecimal qty, BigDecimal total, JFXButton jfxButton) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.total = total;
        this.jfxButton = jfxButton;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public JFXButton getJfxButton() {
        return jfxButton;
    }

    public void setJfxButton(JFXButton jfxButton) {
        this.jfxButton = jfxButton;
    }
}
