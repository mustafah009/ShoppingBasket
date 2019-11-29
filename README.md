### ShoppingBasket
Pairing test for back end Java

* The test is based around a simple checkout pipeline for an online store or POS system.
* A Basket of BasketItems is passed to a CheckoutPipeline. 
* The basket is placed in a CheckoutContext, then passed through a series of CheckoutSteps. 
* These process/update the basket, its items and the context to collect data to produce a final bill.

Instructions:

# Part1:
* We have the start of an implementation for a Shopping Basket service which could be used by either a physical point-of-sale or online store. 
* You'll see we have a Basket definition which contains individual BasketItems, each of which has a product code and quantity. 
* Please can you implement the consolidateItems method in the Basket so that there is no more than one BasketItem with the same productCode within it, and with the quantity in that item set to the sum of the quantities for all items with that code in the original basket.

Expected outcomes:
* Tests that adequately cover initial and expected contents of a basket.
** ConsolidateItems method implemented sucessfully.

# Part2:
The checkout process involves a number of CheckoutSteps. 
* You’ll see there’s one for consolidating the Basket (calling the method you’ve just implemented in part1), and one for pricing the Basket (which uses a PricingService to retrieve prices for products), We need to add a CheckoutStep that uses a PromotionsService to retrieve all Promotions (for example ‘two for the price of one’ on specific products) for a Basket and adds them to the CheckoutContext (for subsequent itemising on a receipts and calculation of the final price).
* Calculation of the final price based on the production is expected to be implemented as well.

Expected outcomes:
* Writing a test for the new implementation of CheckoutStep that mocks the interaction with the PromotionService.
* Successful implementation of a CheckoutStep that uses a PromotionsService and adds the promotions retrieved from the service into the CheckoutContext
