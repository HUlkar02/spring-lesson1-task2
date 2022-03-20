package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.*;

/**
 * @author Hulkar,
 * @time вт 22:16.
 * @project 15.03.2022
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AboutUs extends AbsEntity {


    @Column(nullable = false)
    private String  title;

    @Column(nullable = false)
    private String  description;

}
