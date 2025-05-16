package com.dailycoding.restful_service.controller;

import com.dailycoding.restful_service.entity.College;
import com.dailycoding.restful_service.model.CollegeDTO;
import com.dailycoding.restful_service.service.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;
    @PostMapping("/new")
    public ResponseEntity<College> addCollege(@RequestBody CollegeDTO collegeDTO) {
        College saved = collegeService.createCollege(collegeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<Page<College>> fetchColleges(Pageable pageable){
        return ResponseEntity.ok(collegeService.getAllColleges(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollegeDTO> getCollege(@PathVariable int id) {
        return ResponseEntity.ok(collegeService.getCollegeById(id));
    }
}
