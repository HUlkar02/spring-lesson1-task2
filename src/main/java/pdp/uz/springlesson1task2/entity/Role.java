package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.enums.RoleName;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.*;

/**
 * @author Hulkar,
 * @time вт 22:14.
 * @project 15.03.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Role extends AbsEntity {

    @Column(nullable = false, unique = true)
    @Enumerated(value=EnumType.STRING)
    private RoleName roleName;
}
