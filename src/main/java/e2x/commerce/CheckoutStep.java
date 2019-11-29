package e2x.commerce;

public interface CheckoutStep {
    void execute(CheckoutContext checkoutContext);
}
