package com.learn.student.userdetails.finacials;
public class FeesDTO {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long subjectId;
    private String subjectName;
    private String grade;
    private String academicYear;
    private Double fees;

    // Constructors
    public FeesDTO() {
    }
    public FeesDTO(Long studentId, String firstName, String lastName, Long subjectId, String subjectName,
                   String grade, String academicYear, Double fees) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.grade = grade;
        this.academicYear = academicYear;
        this.fees = fees;
    }

    public FeesDTO(String message) {
    }
    // Getters and setters

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Double getFees() {
        return fees;
    }
    public void setFees(Double fees) {
        this.fees = fees;
    }

}
