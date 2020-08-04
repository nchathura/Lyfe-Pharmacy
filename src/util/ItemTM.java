package util;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemTM {
    private String itemCode;
    private String description;
    private String category;
    private String manufacturer;
    private LocalDate productionDate;
    private LocalDate expiryDate;
    private BigDecimal buyingPrice;
    private BigDecimal sellingPrice;
    private BigDecimal minimumStockLevel;
    private BigDecimal qtyOnHand;
    private BigDecimal unitPrice;

    @Override
    public String toString() {
        return "ItemTM{" +
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

    public ItemTM() {
    }

    public ItemTM(String itemCode, String description, String category, String manufacturer, LocalDate productionDate, LocalDate expiryDate, BigDecimal buyingPrice, BigDecimal sellingPrice, BigDecimal minimumStockLevel, BigDecimal qtyOnHand, BigDecimal unitPrice) {
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

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
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
