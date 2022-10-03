package edu.step.model.tariff;

import lombok.Getter;

@Getter
public enum Tariff {

    EASY_TARIFF(" EASY", 300, 5000, 12.5),
    UNLIMITED_CALLS_TARIFF("CALLS", 2000, 1000, 15.0),
    UNLIMITED_INTERNET_TARIFF("INTERNET", 200, 10000, 20.0);

    private final String title;
    private final Integer minutes;
    private final Integer megaBytes;
    private final Double price;

    Tariff(String title, Integer minutes, Integer megaBytes, Double price) {
        this.title = title;
        this.minutes = minutes;
        this.megaBytes = megaBytes;
        this.price = price;
    }

}
