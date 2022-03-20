package pdp.uz.springlesson1task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.UserDto;
import pdp.uz.springlesson1task2.service.UserService;

/**
 * @author Hulkar,
 * @time вт 22:52.
 * @project 15.03.2022
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.save(userDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody UserDto userDto) {
        ApiResponse editing = userService.edit(id, userDto);
        return ResponseEntity.status(editing!=null?202:409).body(editing);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
