package e2x.commerce;

public class PaymentSummary {
    private double retailPriceTotal;

    public PaymentSummary(double retailPriceTotal) {
        this.retailPriceTotal = retailPriceTotal;
    }

    public double getRetailTotal() {
        return retailPriceTotal;
    }
}
