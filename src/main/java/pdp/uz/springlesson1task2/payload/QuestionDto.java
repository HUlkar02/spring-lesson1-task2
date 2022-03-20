package pdp.uz.springlesson1task2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.springlesson1task2.entity.Module;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * @author Hulkar,
 * @time вс 20:52.
 * @project 20.03.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String  name;

    private String  condition;

    private String  methodHead;

    private Integer moduleId;
}
