package edu.step.dto.phoneDto;


import edu.step.dto.clientDto.ClientPhoneDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Tag(name = "", description = "")
public class PhoneClientDto extends PhoneDtoWithIdAndTariff{

    @Schema(name = "", description = "")
    private ClientPhoneDto client;

}
