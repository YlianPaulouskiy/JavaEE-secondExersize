package edu.step.dto.addressDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "AddressDto", description = "Save fields of address entity")
public class AddressDto {

    @Schema(description = "Resident country of client", example = "Ukraine")
    private String country;

    @Schema(description = "Resident city of client", example = "Kiev")
    private String city;

    @Schema(description = "Street of address resident ", example = "Soviet street")
    private String street;

    @Schema(description = "Number of living house", example = "44b")
    private String house;

    @Schema(description = "Flat number  if exist", example = "21")
    private String room;

}
