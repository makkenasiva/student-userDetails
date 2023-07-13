package com.learn.student.userdetails.Enrollment.Course;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/details")
    public CourseDetails getCourseDetails(@RequestParam int grade, @RequestParam int subjectId) {
        return courseService.getCourseDetailsByGradeAndSubjectId(grade, subjectId);
    }
}
