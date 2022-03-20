package pdp.uz.springlesson1task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.ModuleDto;
import pdp.uz.springlesson1task2.payload.UserDto;
import pdp.uz.springlesson1task2.service.ModuleService;

/**
 * @author Hulkar,
 * @time вт 22:51.
 * @project 15.03.2022
 */
@RestController
@RequestMapping("/api/module")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = moduleService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = moduleService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody ModuleDto moduleDto) {
        ApiResponse apiResponse = moduleService.save(moduleDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody ModuleDto  moduleDto) {
        ApiResponse editing = moduleService.edit(id, moduleDto);
        return ResponseEntity.status(editing!=null?202:409).body(editing);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = moduleService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
