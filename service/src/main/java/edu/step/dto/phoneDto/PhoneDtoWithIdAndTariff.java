package edu.step.dto.phoneDto;

import edu.step.dto.tariffDto.TariffDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "", description = "")
public class PhoneDtoWithIdAndTariff {

    @Schema(name = "", description = "")
    private Long id;

    @Schema(name = "", description = "")
    private TariffDto tariff;

}
