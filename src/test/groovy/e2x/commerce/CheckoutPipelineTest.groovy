package e2x.commerce

import spock.lang.Specification

class CheckoutPipelineTest extends Specification {

    CheckoutPipeline pipeline

    def setup() {
        pipeline = new CheckoutPipeline()

    }

    def "should return zero payment for an empty pipeline"() {
        given:

        Basket basket = Mock()


        when:

        PaymentSummary payment = pipeline.checkout(basket)

        then:

        payment.getRetailTotal() == 0.0
    }

    def "should execute all passed checkout steps"() {
        given:

        Basket basket = Mock()

        CheckoutStep mockStep1 = Mock()
        CheckoutStep mockStep2 = Mock()

        pipeline.addStep(mockStep1)
        pipeline.addStep(mockStep2)

        when:

        PaymentSummary payment = pipeline.checkout(basket)


        // Multiple then: blocks specify order
        then:

        1 * mockStep1.execute({CheckoutContext c -> c.getBasket() == basket})

        then:

        1 * mockStep2.execute({CheckoutContext c -> c.getBasket() == basket})


    }
}

