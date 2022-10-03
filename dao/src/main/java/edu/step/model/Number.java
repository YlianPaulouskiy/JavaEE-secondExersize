package edu.step.model;

import edu.step.model.parent.BaseEntity;
import edu.step.model.tariff.Tariff;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Number extends BaseEntity {

    private String countryCode;
    private String operatorCode;
    private String mobile;
    private Tariff tariff;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
}
