package pdp.uz.springlesson1task2.entity.template;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Hulkar,
 * @time вт 22:18.
 * @project 15.03.2022
 */
@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
