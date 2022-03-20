package pdp.uz.springlesson1task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springlesson1task2.entity.PL;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.PlDto;
import pdp.uz.springlesson1task2.repository.PlRepo;

import java.util.List;
import java.util.Optional;

/**
 * @author Hulkar,
 * @time вс 20:42.
 * @project 20.03.2022
 */
@Service
public class PLService {

    @Autowired
    PlRepo plRepo;

    public ApiResponse getAll() {
        List<PL> all = plRepo.findAll();
        return new ApiResponse(true,"All",all);
    }

    public ApiResponse getOne(Integer id) {
        Optional<PL> optionalUser = plRepo.findById(id);
        if (optionalUser.isEmpty()) {
            return new ApiResponse(false,"Not found");
        }
        return new ApiResponse(true,"By id",optionalUser.get());
    }

    public ApiResponse saveOrEdit(PlDto plDto) {
        PL pl=new PL();
        if (plDto.getId()!=null) {
            pl=plRepo.getById(plDto.getId());
        }
        pl.setName(plDto.getName());
        plRepo.save(pl);
        return new ApiResponse(true,plDto.getId()!=null?"Edited":"Saved");
    }

    public ApiResponse delete(Integer id) {
        try {
            plRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }
        catch (Exception e) {
            return new ApiResponse(false,"Not found");
        }
    }
}
