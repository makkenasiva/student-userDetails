package com.learn.student.userdetails.finacials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FeesController {

    private final FeesService feesService;

    @Autowired
    public FeesController(FeesService feesService) {
        this.feesService = feesService;
    }

    @GetMapping("/enrolled-courses/{studentId}")
    public ResponseEntity<?> getEnrolledCoursesAndFees(@PathVariable Long studentId) {
        List<FeesDTO> enrolledCoursesAndFees = feesService.getEnrolledCoursesAndFees(studentId);

        if (!((List<?>) enrolledCoursesAndFees).isEmpty()) {
            return ResponseEntity.ok(enrolledCoursesAndFees);
        } else {
            String message = "Student not found.";
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return ResponseEntity.ok(response);
        }
    }
}
