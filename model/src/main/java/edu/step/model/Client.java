package edu.step.model;

import edu.step.model.parent.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends BaseModel {

    private Tariff tariff;
    private String number;
    private Person person;

}
