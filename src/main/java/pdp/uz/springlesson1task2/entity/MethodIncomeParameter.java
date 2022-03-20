package pdp.uz.springlesson1task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * @author Hulkar,
 * @time вт 22:44.
 * @project 15.03.2022
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MethodIncomeParameter extends AbsEntity {

    @ManyToOne
    private TaskMethodParameter taskMethodParameter;
    @Column(updatable = true)
    private Timestamp dataType;

    @Column(nullable = false)
    private String variableName;

    @Column(nullable = false)
    private String variableValue;
}
