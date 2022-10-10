package edu.step.entity;

import edu.step.entity.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Tariff extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true, length = 50)
    private String title;

    @Column(name = "minutes", nullable = false)
    private Integer minutes;

    @Column(name = "megabytes", nullable = false)
    private Integer megabytes;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phoneList;

}
