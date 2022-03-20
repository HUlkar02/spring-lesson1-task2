package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Hulkar,
 * @time вт 22:37.
 * @project 15.03.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskCase extends AbsEntity {

    @ManyToOne
    public Question task;

    private String  answer;
}
