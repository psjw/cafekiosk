package com.psjw.cafekisok.unit.order;

import com.psjw.cafekisok.unit.beverage.Beverage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Order {
    private final LocalDateTime orderDateTime;

    private final List<Beverage> beverages;
}
