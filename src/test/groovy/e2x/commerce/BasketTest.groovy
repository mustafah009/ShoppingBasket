package e2x.commerce

import spock.lang.Specification

class BasketTest extends Specification {

    def "should be empty on construction"() {
        given:

        Basket basket = new Basket()

        when:

        List<BasketItem> items = basket.getItems()

        then:

        items.size() == 0
    }

    def "should construct basket item from all parameters to basket.add"() {
        given:

        Basket basket = new Basket()

        String productCode1 = "product1"
        String productName1 = "product one"

        basket.add(productCode1, productName1, 1)

        when:

        List<BasketItem> items = basket.getItems()

        then:

        items.size() == 1

        items[0].getProductCode() == productCode1
        items[0].getProductName() == productName1
        items[0].getQuantity()    == 1
    }

    def "should pass items to eachItem callback"() {
        given:

        Basket basket = new Basket()

        String productCode1 = "product1"
        String productCode2 = "product2"
        String productName1 = "product one"
        String productName2 = "product two"
        basket.add(productCode1, productName1, 1)
        basket.add(productCode2, productName2, 1)
        basket.add(productCode1, productName1, 1)

        when:

        List<BasketItem> items = basket.getItems()

        then:

        items.size() == 3

        items[0].getProductCode() == productCode1
        items[0].getProductName() == productName1
        items[0].getQuantity()    == 1

        items[1].getProductCode() == productCode2
        items[1].getProductName() == productName2
        items[1].getQuantity()    == 1

        items[2].getProductCode() == productCode1
        items[2].getProductName() == productName1
        items[2].getQuantity()    == 1


    }


    def "should consolidate basket items"() {
        // Exercise - write test for and implement basket consolidation
    }

}
