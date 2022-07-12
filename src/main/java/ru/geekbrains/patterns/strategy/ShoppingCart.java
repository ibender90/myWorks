package ru.geekbrains.patterns.strategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Long, Product> products = new HashMap<>();

    private Discountable discountable;

    public void addToCart(Product product) {
        products.put(product.getId(), product);
    }

    public void removeFromCart(Product product) {
        products.remove(product.getId());
    }

    public void setDiscountable(Discountable discountable) {
        this.discountable = discountable;
    }

    public BigDecimal calcTotal() {
        BigDecimal value = products.values().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (discountable != null) {
            value = discountable.applyDiscount(value);
        }
        return value;
    }
}
