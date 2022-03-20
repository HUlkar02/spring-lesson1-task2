package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.*;

/**
 * @author Hulkar,
 * @time вт 22:12.
 * @project 15.03.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbsEntity {

      @Column(nullable = false,unique = true)
    private String  email;

    @Column(nullable = false)
    private String  password;

    @ManyToOne
    private Role role;


}
