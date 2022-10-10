package edu.step.dto.tariffDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;

@Getter
@Tag(name = ",", description = ",")
public enum TariffDto {

    EASY_TARIFF(" EASY", 300, 5000, 12.5),
    UNLIMITED_CALLS_TARIFF("CALLS", 2000, 1000, 15.0),
    UNLIMITED_INTERNET_TARIFF("INTERNET", 200, 10000, 20.0);

    @Schema(name = "", description = "")
    private final String title;
    @Schema(name = "", description = "")
    private final Integer minutes;
    @Schema(name = "", description = "")
    private final Integer megaBytes;
    @Schema(name = "", description = "")
    private final Double price;

    TariffDto(String title, Integer minutes, Integer megaBytes, Double price) {
        this.title = title;
        this.minutes = minutes;
        this.megaBytes = megaBytes;
        this.price = price;
    }
}
