package edu.step.entity;

import edu.step.entity.parent.BaseEntity;
import edu.step.entity.tariff.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Phone extends BaseEntity {

    private String countryCode;
    private String operatorCode;
    private String mobile;
    private Tariff tariff;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
}
