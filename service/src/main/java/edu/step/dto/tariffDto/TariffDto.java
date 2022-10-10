package edu.step.dto.tariffDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = ",", description = ",")
public class TariffDto {

    @Schema(name = "", description = "")
    private String title;
    @Schema(name = "", description = "")
    private Integer minutes;
    @Schema(name = "", description = "")
    private Integer megaBytes;
    @Schema(name = "", description = "")
    private Double price;

}
