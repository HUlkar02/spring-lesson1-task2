package pdp.uz.springlesson1task2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hulkar,
 * @time вт 23:08.
 * @project 15.03.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String email;
    private String  password;
    private Integer roleId;

}
