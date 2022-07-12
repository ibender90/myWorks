package ru.geekbrains.patterns.strategy;

import java.math.BigDecimal;

public interface Discountable {

    BigDecimal applyDiscount(BigDecimal value);
}
