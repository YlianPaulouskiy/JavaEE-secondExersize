package edu.step.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String room;
    private ClientDto client;

}
