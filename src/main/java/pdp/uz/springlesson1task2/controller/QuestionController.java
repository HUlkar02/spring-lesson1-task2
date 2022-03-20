package pdp.uz.springlesson1task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.QuestionDto;
import pdp.uz.springlesson1task2.payload.UserDto;
import pdp.uz.springlesson1task2.service.QuestionService;

/**
 * @author Hulkar,
 * @time вт 22:52.
 * @project 15.03.2022
 */
@RestController
@RequestMapping("/api/question")
public class QuestionController {


    @Autowired
    QuestionService questionService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = questionService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = questionService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody QuestionDto dto) {
        ApiResponse apiResponse = questionService.save(dto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody QuestionDto dto) {
        ApiResponse editing = questionService.edit(id, dto);
        return ResponseEntity.status(editing!=null?202:409).body(editing);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = questionService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
