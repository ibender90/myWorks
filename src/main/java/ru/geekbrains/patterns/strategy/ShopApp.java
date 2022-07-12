package ru.geekbrains.patterns.strategy;

import java.math.BigDecimal;

public class ShopApp {
    public static void main(String[] args) {
        Product product = new Product(1L, "Product", new BigDecimal(100));

        ShoppingCart cart = new ShoppingCart();
        cart.setDiscountable(new FixedDiscount(new BigDecimal("0.1")));
        //cart.setDiscountable(new PercentDiscount(new BigDecimal("10")));
        cart.addToCart(product);
        System.out.println("Total = " + cart.calcTotal());

    }
}
