package pdp.uz.springlesson1task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.springlesson1task2.entity.User;

/**
 * @author Hulkar,
 * @time вт 23:02.
 * @project 15.03.2022
 */
public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByRoleIdAndEmail(Integer role_id, String email);
}
