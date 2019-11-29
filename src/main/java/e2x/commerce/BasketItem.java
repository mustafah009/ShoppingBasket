package e2x.commerce;

public class BasketItem {
    private String productCode;
    private String productName;
    private int quantity;
    private double productRetailPrice;

    public BasketItem(String productCode, String productName, int quantity) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProductRetailPrice(double productRetailPrice) {
        this.productRetailPrice = productRetailPrice;
    }

    public double getProductRetailPrice() {
        return productRetailPrice;
    }

    public double getTotalRetailPrice() {
        return quantity * productRetailPrice;
    }

    public String getProductName() {
        return productName;
    }
}
