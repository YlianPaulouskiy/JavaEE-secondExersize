package edu.step.dto.clientDto;

import edu.step.dto.addressDto.AddressDto;
import edu.step.dto.phoneDto.PhoneClientDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Tag(name = "", description = "")
public class ClientPhoneDto extends ClientDtoWithIdAndDate {

    @Schema(name = "", description = "")
    private List<PhoneClientDto>  phoneList;

    @Schema(name = "", description = "")
    private AddressDto address;
}
