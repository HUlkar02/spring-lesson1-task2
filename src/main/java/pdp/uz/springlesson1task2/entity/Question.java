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
 * @time вт 22:24.
 * @project 15.03.2022
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question extends AbsEntity {

    @Column(nullable = false)
    private String  name;

    @Column(nullable = false)
    private String  condition;

    @Column(nullable = false)
    private String  methodHead;

    @ManyToOne
    private Module module;
}
