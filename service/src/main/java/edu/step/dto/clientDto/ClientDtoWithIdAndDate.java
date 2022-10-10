package edu.step.dto.clientDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Tag(name = "", description = "")
public class ClientDtoWithIdAndDate extends ClientDto {

    @Schema(name = "", description = "")
    private Long id;
    @Schema(name = "", description = "")
    private Date dateAdded;

}
