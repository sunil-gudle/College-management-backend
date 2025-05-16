package com.dailycoding.restful_service.service;

import com.dailycoding.restful_service.entity.College;
import com.dailycoding.restful_service.model.CollegeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CollegeService {

    College createCollege(CollegeDTO collegeDTO);

    Page<College> getAllColleges(Pageable pageable);

    CollegeDTO getCollegeById(int id);

}
