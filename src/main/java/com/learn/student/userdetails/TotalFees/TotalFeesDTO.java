package com.learn.student.userdetails.TotalFees;

public class TotalFeesDTO {

    private Long studentId;
    private String firstName;
    private String lastName;
    private double totalSubjectFees;
    private double totalFeesAfterScholarship;

    // No-argument constructor
    public TotalFeesDTO() {
    }

    public TotalFeesDTO(Long studentId, String firstName, String lastName, double totalSubjectFees, double totalFeesAfterScholarship) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalSubjectFees = totalSubjectFees;
        this.totalFeesAfterScholarship = totalFeesAfterScholarship;
    }


    // Getters and Setters (you can generate these using your IDE or create manually if needed)

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

    public double getTotalSubjectFees() {
        return totalSubjectFees;
    }

    public void setTotalSubjectFees(double totalSubjectFees) {
        this.totalSubjectFees = totalSubjectFees;
    }

    public double getTotalFeesAfterScholarship() {
        return totalFeesAfterScholarship;
    }

    public void setTotalFeesAfterScholarship(double totalFeesAfterScholarship) {
        this.totalFeesAfterScholarship = totalFeesAfterScholarship;
    }
}


