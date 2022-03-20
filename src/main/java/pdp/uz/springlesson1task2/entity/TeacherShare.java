package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Hulkar,
 * @time вт 22:32.
 * @project 15.03.2022
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TeacherShare extends AbsEntity {

    @OneToOne
    private User teacher;

    @OneToMany
    private List<User> student;


}
