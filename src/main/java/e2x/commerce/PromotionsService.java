package e2x.commerce;

import java.util.List;

interface PromotionsService {
    List<Promotion> getPromotions(Basket basket);
}
