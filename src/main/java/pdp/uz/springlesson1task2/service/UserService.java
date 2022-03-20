package pdp.uz.springlesson1task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.springlesson1task2.entity.Role;
import pdp.uz.springlesson1task2.entity.User;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.UserDto;
import pdp.uz.springlesson1task2.repository.RoleRepo;
import pdp.uz.springlesson1task2.repository.UserRepo;

import java.util.Optional;

/**
 * @author Hulkar,
 * @time вт 23:05.
 * @project 15.03.2022
 */

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    public ApiResponse getAll() {

        return new ApiResponse(true,"All user",userRepo.findAll());
    }

    public ApiResponse getOne(Integer id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.map(user -> new ApiResponse(true, "By id", user)).orElseGet(() -> new ApiResponse(false, "User Not found"));
    }

    public ApiResponse save(UserDto userDto) {
        boolean exists = userRepo.existsByRoleIdAndEmail(userDto.getRoleId(), userDto.getEmail());
        if (exists)
            return new ApiResponse(false, "User already exist");

        Optional<Role> optional = roleRepo.findById(userDto.getRoleId());
        if (optional.isPresent()) {
            User user = new User(userDto.getEmail(),userDto.getPassword(), optional.get());
            userRepo.save(user);
            return new ApiResponse(true, "User added");

        }
        return new ApiResponse(false, "Role not found");
    }

    public ApiResponse delete(Integer id) {
        try {
            userRepo.deleteById(id);
            return new ApiResponse(true,"Deleted");
        }catch (Exception e){
            return new ApiResponse(false,"User not deleted");
        }
    }

    public ApiResponse edit(Integer id,UserDto userDto) {
            Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            Optional<Role> optional1 = roleRepo.findById(userDto.getRoleId());
            try {
                User edited = userRepo.save(
                        new User(userDto.getEmail(), userDto.getPassword(), optional1.get()));
                return new ApiResponse(true, "User edited",edited);
            } catch (Exception e) {
                return new ApiResponse(false, "User already exist!!");
            }
        }
        return new ApiResponse(false, "User not found");
    }
}
