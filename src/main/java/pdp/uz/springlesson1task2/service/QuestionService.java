package pdp.uz.springlesson1task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springlesson1task2.entity.Module;
import pdp.uz.springlesson1task2.entity.Question;
import pdp.uz.springlesson1task2.entity.Role;
import pdp.uz.springlesson1task2.entity.User;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.QuestionDto;
import pdp.uz.springlesson1task2.payload.UserDto;
import pdp.uz.springlesson1task2.repository.ModuleRepo;
import pdp.uz.springlesson1task2.repository.QuestionRepo;

import java.util.List;
import java.util.Optional;

/**
 * @author Hulkar,
 * @time вс 20:51.
 * @project 20.03.2022
 */
@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    ModuleRepo moduleRepo;

    public ApiResponse getAll() {
        List<Question> all = questionRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Question> optionalUser = questionRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalUser.get());
    }

    public ApiResponse save(QuestionDto questionDto) {
        boolean exists = questionRepo.existsByModuleId(questionDto.getModuleId());
        if (exists)
            return new ApiResponse(false, "Question already exist");

        Optional<Module> optional = moduleRepo.findById(questionDto.getModuleId());
        if (optional.isPresent()) {
            Question question = new Question(questionDto.getName(), questionDto.getCondition(), questionDto.getMethodHead(),optional.get());
            questionRepo.save(question);
            return new ApiResponse(true, "Question added");

        }
        return new ApiResponse(false, "Module not found");
    }

    public ApiResponse delete(Integer id) {
        try {
            questionRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }catch (Exception e){
            return new ApiResponse(false,"Not deleted");
        }
    }


    public ApiResponse edit(Integer id, QuestionDto dto) {
        Optional<Question> optional = questionRepo.findById(id);
        if (optional.isPresent()) {
            Optional<Module> optional1 = moduleRepo.findById(dto.getModuleId());
            try {
                Question edited = questionRepo.save(
                        new Question(dto.getName(), dto.getCondition(), dto.getMethodHead(), optional1.get()));
                return new ApiResponse(true, "Question edited",edited);
            } catch (Exception e) {
                return new ApiResponse(false, "Question already exist!!");
            }
        }
        return new ApiResponse(false, "Question not found");
    }
}
