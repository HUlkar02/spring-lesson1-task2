package pdp.uz.springlesson1task2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hulkar,
 * @time вс 18:11.
 * @project 20.03.2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleDto {
   private String  name;
   private Integer plId;
}
