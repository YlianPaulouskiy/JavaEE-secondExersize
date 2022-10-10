package edu.step.dto.tariffDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Tag(name = "", description = "")
@Data
public class TariffDtoWithId extends TariffDto {

    @Schema(name = "", description = "")
    private Long id;

}
