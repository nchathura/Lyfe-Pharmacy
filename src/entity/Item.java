package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Item implements Serializable {
    private String itemCode;
    private String description;
    private String category;
    private String manufacturer;
    private Date productionDate;
    private Date expiryDate;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private BigDecimal minimumStockLevel;
    private BigDecimal qtyOnHand;
    private BigDecimal unitPrice;

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productionDate=" + productionDate +
                ", expiryDate=" + expiryDate +
                ", buyingPrice=" + buyingPrice +
                ", sellingPrice=" + sellingPrice +
                ", minimumStockLevel=" + minimumStockLevel +
                ", qtyOnHand=" + qtyOnHand +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public Item() {
    }

    public Item(String itemCode, String description, String category, String manufacturer, Date productionDate, Date expiryDate, BigDecimal buyingPrice, BigDecimal sellingPrice, BigDecimal minimumStockLevel, BigDecimal qtyOnHand, BigDecimal unitPrice) {
        this.itemCode = itemCode;
        this.description = description;
        this.category = category;
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.minimumStockLevel = minimumStockLevel;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(BigDecimal minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
