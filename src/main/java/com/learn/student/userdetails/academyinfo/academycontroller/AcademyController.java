package com.learn.student.userdetails.academyinfo.academycontroller;
import com.learn.student.userdetails.academyinfo.academyinformation.AcademyModel;
import com.learn.student.userdetails.academyinfo.academyservice.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academy")
public class AcademyController {

    private final AcademyService academyService;

    @Autowired
    public AcademyController(AcademyService academyService) {
        this.academyService = academyService;
    }

    @GetMapping("/student/{studentId}")
    public List<AcademyModel> getAcademicInfoByStudentId(@PathVariable Integer studentId) {
        return academyService.getAcademicInfoByStudentId(studentId);
    }
}
