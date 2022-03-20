package pdp.uz.springlesson1task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springlesson1task2.entity.Module;
import pdp.uz.springlesson1task2.entity.PL;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.ModuleDto;
import pdp.uz.springlesson1task2.repository.ModuleRepo;
import pdp.uz.springlesson1task2.repository.PlRepo;

import java.util.Optional;

/**
 * @author Hulkar,
 * @time вт 23:05.
 * @project 15.03.2022
 */

@Service
public class ModuleService {


    @Autowired
    ModuleRepo moduleRepo;

    @Autowired
    PlRepo plRepo;

    public ApiResponse getAll() {
        return new ApiResponse(true,"All module",moduleRepo.findAll());
    }

    public ApiResponse getOne(Integer id) {
        Optional<Module> byId = moduleRepo.findById(id);
        return byId.map(module -> new ApiResponse(true,"By id",module))
                .orElseGet(()->new ApiResponse(false,"Module not found"));
    }

    public ApiResponse save(ModuleDto moduleDto) {
        boolean exists = moduleRepo.existsByPlId(moduleDto.getPlId());
        if (exists)
            return new ApiResponse(false,"Module already exist");

        Optional<PL> optional = plRepo.findById(moduleDto.getPlId());
        if (optional.isPresent()){
            Module module= new Module(moduleDto.getName(), optional.get());
            moduleRepo.save(module);
            return new ApiResponse(true, "Module added");

        }
        return new ApiResponse(false, "Role not found");
    }

    public ApiResponse delete(Integer id) {
        try{
            moduleRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }catch (Exception e){
            return new ApiResponse(false,"Module not deleted");
        }
    }

    public ApiResponse edit(Integer id, ModuleDto moduleDto) {
        Optional<Module> module = moduleRepo.findById(id);
        if (module.isPresent()){
            Optional<PL> pl = plRepo.findById(moduleDto.getPlId());
            try {
                Module edited=moduleRepo.save(
                        new Module(moduleDto.getName(), pl.get())
                );
                return new ApiResponse(true,"Module edited",edited);

            }catch (Exception e){
                return new ApiResponse(false,"Module not edited");
            }
        }
        return new ApiResponse(false,"Module not found");
    }
}
