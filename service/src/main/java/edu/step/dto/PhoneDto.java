package edu.step.dto;

import lombok.Data;

@Data
public class PhoneDto {

    private Long id;
    private String countryCode;
    private String operatorCode;
    private String mobile;
    private TariffDto tariff;
    private ClientDto client;

}
