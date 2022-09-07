package edu.step.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tariff {

    private String title;
    private Integer minutes;
    private Integer megaBytes;
    private Double price;

}
