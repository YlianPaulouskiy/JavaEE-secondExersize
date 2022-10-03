package edu.step.model;

import edu.step.model.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends BaseEntity {

    private String name;
    private String lastName;
    private String patronymic;

    @OneToOne(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;


}
