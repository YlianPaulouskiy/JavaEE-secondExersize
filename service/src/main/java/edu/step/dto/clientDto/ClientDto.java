package edu.step.dto.clientDto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.Date;

@Data
@Tag(name = "", description = "")
public class ClientDto {

    @Schema(name = "", description = "")
    private String name;

    @Schema(name = "", description = "")
    private String lastName;

    @Schema(name = "", description = "")
    private String patronymic;

    @Schema(name = "", description = "")
    private Date dateAdded;

}
