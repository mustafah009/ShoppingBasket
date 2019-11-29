package e2x.commerce

import spock.lang.Specification

class RetailPriceCheckoutStepTest extends Specification {

    PricingService mockPricingService
    CheckoutContext mockCheckoutContext
    Basket basket

    def setup() {
        mockPricingService = Mock()
        mockCheckoutContext = Mock()
        basket = new Basket()
        mockCheckoutContext.getBasket() >> basket
    }

    def "should set price of 0 for empty basket"() {
        given:

        RetailPriceCheckoutStep checkoutStep = new RetailPriceCheckoutStep(mockPricingService)

        when:

        checkoutStep.execute(mockCheckoutContext)

        then:

        1 * mockCheckoutContext.setRetailPriceTotal(0.0)
    }

    def "should set price of product to basket item"() {
        given:

        String productCode1 = "product1"
        String productName1 = "product one"
        basket.add(productCode1, productName1, 2)

        RetailPriceCheckoutStep checkoutStep = new RetailPriceCheckoutStep(mockPricingService)

        when:
        checkoutStep.execute(mockCheckoutContext)

        then:
        1 * mockPricingService.getPrice(productCode1) >> 3.99
        1 * mockCheckoutContext.setRetailPriceTotal(3.99 * 2)

        basket.getItems()[0].getProductRetailPrice() == 3.99D
        basket.getItems()[0].getTotalRetailPrice()   == 3.99D * 2
    }

    def "should total amounts and quantities of items in basket"() {
        given:

        String productCode1 = "product1"
        String productCode2 = "product2"
        String productName1 = "product one"
        String productName2 = "product two"
        basket.add(productCode1, productName1, 1)
        basket.add(productCode2, productName2, 2)

        RetailPriceCheckoutStep checkoutStep = new RetailPriceCheckoutStep(mockPricingService)

        when:

        checkoutStep.execute(mockCheckoutContext)

        then:

        1 * mockPricingService.getPrice(productCode1) >> 3.99
        1 * mockPricingService.getPrice(productCode2) >> 4.50
        1 * mockCheckoutContext.setRetailPriceTotal(1 * 3.99 + 2 * 4.50)

    }
}
