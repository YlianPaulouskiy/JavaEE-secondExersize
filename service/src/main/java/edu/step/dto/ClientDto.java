package edu.step.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private Long id;
    private String name;
    private String lastName;
    private String patronymic;
    private AddressDto address;
    private List<PhoneDto> phoneList;

}
