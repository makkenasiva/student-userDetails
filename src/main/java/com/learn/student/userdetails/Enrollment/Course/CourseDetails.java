package com.learn.student.userdetails.Enrollment.Course;

public class CourseDetails {
    private String subjectName;
    private String courseDescription;
    private int seatsAvailable;

    public CourseDetails(String subjectName, String courseDescription, int seatsAvailable) {
        this.subjectName = subjectName;
        this.courseDescription = courseDescription;
        this.seatsAvailable = seatsAvailable;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
