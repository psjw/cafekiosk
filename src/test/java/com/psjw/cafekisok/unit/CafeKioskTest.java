package com.psjw.cafekisok.unit;

import com.psjw.cafekisok.unit.beverage.Americano;
import com.psjw.cafekisok.unit.beverage.Latte;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {

    @Test
    void add_maual_test() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        //올바른 테스트 일까? 무조건 성공 -> 무엇을 검증하는지 다른사람이 알수 없음
        System.out.println(">>> 담긴 음료 수 : " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료 : " + cafeKiosk.getBeverages().get(0).getName());
    }

    @Test
    void add() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());
        Assertions.assertThat(cafeKiosk.getBeverages().size()).isEqualTo(1);
        Assertions.assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");

    }

    @Test
    void addServeralBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        cafeKiosk.add(americano, 2);
        Assertions.assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano);
        Assertions.assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano);

    }


    @Test
    void addZeroBeverages() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        Assertions.assertThatThrownBy(() -> cafeKiosk.add(americano, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.");

    }

    @Test
    void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);
        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(1);

        cafeKiosk.remove(americano);
        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(0);
    }

    @Test
    void clear() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);
        Assertions.assertThat(cafeKiosk.getBeverages()).hasSize(2);

        cafeKiosk.clear();
        Assertions.assertThat(cafeKiosk.getBeverages()).isEmpty();

    }
}