package e2x.commerce

import spock.lang.Specification

class BasketConsolidationCheckoutStepTest extends Specification {
    def "should ask basket to consolidate itself"() {
        given:

        CheckoutContext mockCheckoutContext = Mock()
        Basket mockBasket = Mock()

        BasketConsolidationCheckoutStep basketConsolodationCheckoutStep = new BasketConsolidationCheckoutStep()

        when:

        basketConsolodationCheckoutStep.execute(mockCheckoutContext)

        then:

        1 * mockCheckoutContext.getBasket() >> mockBasket
        1 * mockBasket.consolidateItems()

    }
}
