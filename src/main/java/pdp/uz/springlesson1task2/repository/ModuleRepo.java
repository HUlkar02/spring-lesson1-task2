package pdp.uz.springlesson1task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.springlesson1task2.entity.Module;

/**
 * @author Hulkar,
 * @time вт 23:14.
 * @project 15.03.2022
 */
public interface ModuleRepo extends JpaRepository<Module,Integer> {

    boolean existsByPlId(Integer pl_id);
}
