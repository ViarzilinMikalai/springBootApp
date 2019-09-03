package by.itstep.viarzilin.domain;

import by.itstep.viarzilin.domain.AbstractClasses.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class Car extends AbstractEntity {

    @NotBlank(message = "Заполни поле")
    private String mark;

    @NotBlank(message = "Заполни поле")
    private String model;

    @Pattern(regexp = "[a-z0-9]{17}")
    private String vin;

    @NotBlank(message = "Заполни поле")
    private String color;

}
