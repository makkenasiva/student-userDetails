package com.learn.student.userdetails.scholarships;

public class ScholarshipDTO {
    private Long studentId;
    private Long scholarshipId;
    private Double scholarshipAmount;


    // No-argument constructor
    public ScholarshipDTO() {
    }

    // Constructor with scholarship details
    public ScholarshipDTO(Long studentId, Long scholarshipId, Double scholarshipAmount) {
        this.studentId = studentId;
        this.scholarshipId = scholarshipId;
        this.scholarshipAmount = scholarshipAmount;
    }

    // Constructor with student not eligible message

    // Getters and setters

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getScholarshipId() {
        return scholarshipId;
    }

    public void setScholarshipId(Long scholarshipId) {
        this.scholarshipId = scholarshipId;
    }

    public Double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(Double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

}
