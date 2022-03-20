package pdp.uz.springlesson1task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.springlesson1task2.entity.Question;

/**
 * @author Hulkar,
 * @time вт 23:02.
 * @project 15.03.2022
 */
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    boolean existsByModuleId(Integer module_id);
}
