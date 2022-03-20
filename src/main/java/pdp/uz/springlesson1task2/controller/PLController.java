package pdp.uz.springlesson1task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.springlesson1task2.payload.ApiResponse;
import pdp.uz.springlesson1task2.payload.PlDto;
import pdp.uz.springlesson1task2.service.PLService;

@RestController
@RequestMapping("/api/pl")
public class PLController {

    @Autowired
    PLService plService;

    @GetMapping
    public HttpEntity<?> getAll() {

        ApiResponse apiResponse = plService.getAll();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse apiResponse = plService.getOne(id);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody PlDto plDto) {
        ApiResponse apiResponse = plService.saveOrEdit(plDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/edit")
    public HttpEntity<?> edit(@RequestBody PlDto plDto) {
        ApiResponse apiResponse = plService.saveOrEdit(plDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        ApiResponse apiResponse = plService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }
}
