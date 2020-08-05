package entity;

public class OrderDetailPK {
    private String orderId;
    private String itemCode;

    @Override
    public String toString() {
        return "OrderDetailPK{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                '}';
    }

    public OrderDetailPK() {
    }

    public OrderDetailPK(String orderId, String itemCode) {
        this.orderId = orderId;
        this.itemCode = itemCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
