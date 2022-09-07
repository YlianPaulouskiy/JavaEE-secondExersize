package edu.step.model.parent;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseModel implements Serializable {

    private Long id;

}
