package edu.step.dto.phoneDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "", description = "")
public class PhoneDto {

    @Schema(name = "", description = "")
    private String countryCode;
    @Schema(name = "", description = "")
    private String operatorCode;
    @Schema(name = "", description = "")
    private String mobile;

}
