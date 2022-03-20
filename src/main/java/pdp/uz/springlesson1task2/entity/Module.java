package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Hulkar,
 * @time вт 22:23.
 * @project 15.03.2022
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "modules")
public class Module extends AbsEntity {

    @Column(nullable = false)
    private String  name;

    @ManyToOne
    private PL pl;

}
